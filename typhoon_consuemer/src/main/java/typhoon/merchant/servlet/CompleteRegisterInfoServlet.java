package typhoon.merchant.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import typhoon.merchant.pojo.Food;
import typhoon.merchant.pojo.RegisterInfo;
import typhoon.merchant.pojo.User;
import typhoon.merchant.service.RegisterInfoService;
import typhoon.merchant.service.ResturantService;
import typhoon.merchant.service.UserService;
import typhoon.merchant.service.impl.RegisterInfoServiceImpl;
import typhoon.merchant.service.impl.ResturantServiceImpl;
import typhoon.merchant.service.impl.UserServiceImpl;
import typhoon.merchant.util.ImgUtil;

/**
 * Servlet implementation class CompleteRegisterInfoServlet
 */
public class CompleteRegisterInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = UserServiceImpl.getInstance();
	RegisterInfoService registerInfoService = RegisterInfoServiceImpl.getInstance();
	ResturantService resturantService = ResturantServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		String shopId = user.getShopId();// id
		FileUpload upload = new FileUpload(new DiskFileItemFactory());
		String creditCode = null;// 工商号
		String idCard = null;// 身份证
		String picture = null;// 身份证图片
		String picture2 = null;// 身份证图片
		String phone = null;// 电话
		String shopName = null;// 店名
		String address = null;// 地址
		String comments = null;// 备注
		String corporateName = null;// 法人名
		List<FileItem> fileItems = null;
		ImgUtil imgUtil = new ImgUtil();
		try {
			fileItems = upload.parseRequest(new ServletRequestContext(request));
			for (FileItem fileItem : fileItems) {
				if (fileItem.isFormField()) {
					if (fileItem.getFieldName().equals("creditCode")) {
						creditCode = fileItem.getString();
					} else if (fileItem.getFieldName().equals("idCard")) {
						idCard = fileItem.getString();
					} else if (fileItem.getFieldName().equals("phone")) {
						phone = fileItem.getString();
					} else if (fileItem.getFieldName().equals("shopName")) {
						shopName = fileItem.getString();
					} else if (fileItem.getFieldName().equals("address")) {
						address = fileItem.getString();
					} else if (fileItem.getFieldName().equals("comments")) {
						comments = fileItem.getString();
					} else if (fileItem.getFieldName().equals("corporateName")) {
						corporateName = fileItem.getString();
					}
					// System.out.println(fileItem.getFieldName() + "\t" + fileItem.getString());
				} else {
					InputStream in = fileItem.getInputStream();
					picture = imgUtil.img2String(in);
					byte[] buf = fileItem.get();
					String fileName = fileItem.getName();
					OutputStream out = new FileOutputStream(
							this.getServletContext().getRealPath("/img") + "/" + fileName);
					picture2 = "img/" + fileItem.getName();
					out.write(buf);
					out.close();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		RegisterInfo registerInfo1 = new RegisterInfo(shopId, creditCode, idCard, corporateName, picture, phone,
				shopName, address, comments);
		RegisterInfo registerInfo2 = new RegisterInfo(shopId, creditCode, idCard, corporateName, picture2, phone,
				shopName, address, comments);
		System.out.println(registerInfo1.toString());
		System.out.println(registerInfo2.toString());
		userService.sendRegisterInfoToAdmin(registerInfo1);
		registerInfoService.addRegisterInfo(registerInfo2);
		resturantService.addResturant(shopId);
		// request.setAttribute("checkStatus", userService.receiveCheckStatus(shopId));
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
}
