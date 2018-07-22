package typhoon.merchant.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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

import typhoon.merchant.pojo.Food;
import typhoon.merchant.pojo.User;
import typhoon.merchant.service.FoodService;
import typhoon.merchant.service.impl.FoodServiceImpl;
import typhoon.merchant.util.FileUtil;
import typhoon.merchant.util.JsonParse;
import typhoon.merchant.util.JsonParseByJackson;

/**
 * Servlet implementation class UpdatefoodServlet
 */
public class UpdatefoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FileUtil fileUtil = new FileUtil();
	FoodService foodService = FoodServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("user");
		String shopId = user.getShopId();
		request.setCharacterEncoding("UTF-8");
		
		FileUpload upload = new FileUpload(new DiskFileItemFactory());
		List<FileItem> fileItems = null;
		Food food = null;
		String foodName = null;
		Double price = null;
		String info = null;
		String status = null;
		String picture = null;
		String fileName = "default.img";
		int id = 0;
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
					} else if (fileItem.getFieldName().equals("id")) {
						id = Integer.parseInt(fileItem.getString());
					}
					System.out.println(fileItem.getFieldName() + "\t" + fileItem.getString());
				} else {
					InputStream in = fileItem.getInputStream();
					byte[] buf = fileItem.get();
					fileName = fileItem.getName();
					OutputStream out = new FileOutputStream(this.getServletContext().getRealPath("/img") + "/" + fileName);
					picture = "img/" + fileItem.getName();
					out.write(buf);
					out.close();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		food = new Food(id, foodName, price, picture, info, status, shopId);
		System.out.println(food.toString());
		foodService.updateFood(food);
		
		
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", -10);
		PrintWriter out = response.getWriter();
		JsonParse<Food> jsonUtil = new JsonParseByJackson<>();
		Food updatefood = (Food) foodService.FindFoodById(id);
		String result = jsonUtil.parseObjectToJson(updatefood);
		out.print(result);
		System.out.println(result);
		out.flush();
		
//		foodService.UpdateFood(request, this.getServletContext().getRealPath("/img"), shopId);
//		request.getRequestDispatcher("ShowFoodsServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
