package typhoon.merchant.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import typhoon.merchant.dao.FoodDao;
import typhoon.merchant.dao.impl.FoodDaoImpl;
import typhoon.merchant.dao.impl.ResturantDaoImpl;
import typhoon.merchant.pojo.Food;
import typhoon.merchant.pojo.User;
import typhoon.merchant.service.FoodService;
import typhoon.merchant.service.impl.FoodServiceImpl;
import typhoon.merchant.util.FileUtil;
import typhoon.merchant.util.UUIDUtil;

/**
 * Servlet implementation class AddfoodServlet
 */
public class AddfoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	FoodDao foodDao = new FoodDaoImpl();
	FileUtil fileUtil = new FileUtil();
	FoodService foodService = FoodServiceImpl.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("--------------------AddfoodServlet-------------------------");
		User user = (User) request.getSession().getAttribute("user");
		String shopId = user.getShopId();
		request.setCharacterEncoding("UTF-8");

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileUpload upload = new FileUpload(new DiskFileItemFactory());
		List<FileItem> fileItems = null;
		Food food = null;
		String foodName = null;
		Double price = null;
		String info = null;
		String status = null;
		String picture = null;
		try {
			fileItems = upload.parseRequest(new ServletRequestContext(request));
			for (FileItem fileItem : fileItems) {
				if (fileItem.isFormField()) {

					if (fileItem.getFieldName().equals("foodName")) {
						foodName = new String(fileItem.getString().getBytes("iso8859-1"), "UTF-8");
					} else if (fileItem.getFieldName().equals("price")) {
						price = Double.valueOf(fileItem.getString());
					} else if (fileItem.getFieldName().equals("info")) {
						info = new String(fileItem.getString().getBytes("iso8859-1"), "UTF-8");
					} else if (fileItem.getFieldName().equals("status")) {
						status = new String(fileItem.getString().getBytes("iso8859-1"), "UTF-8");
					}
					System.out.println(fileItem.getFieldName() + "\t" + fileItem.getString());
				} else {
					InputStream in = fileItem.getInputStream();
					// picture = imgUtil.img2String(in);
					byte[] buf = fileItem.get();
					String fileName = UUIDUtil.uuid32()+fileItem.getName();
					OutputStream out = new FileOutputStream(this.getServletContext().getRealPath("/img") + "/" + fileName);
					picture = "img/" + fileName;
					out.write(buf);
					out.close();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		food = new Food(foodName, price, picture, info, status, shopId);
		System.out.println(food.toString());
		foodService.addFood(food);
//		foodService.AddFood(request, this.getServletContext().getRealPath("/img"), shopId);
//		request.getRequestDispatcher("ShowFoodsServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
