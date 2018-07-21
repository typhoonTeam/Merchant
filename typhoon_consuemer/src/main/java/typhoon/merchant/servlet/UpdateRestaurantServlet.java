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
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import typhoon.merchant.pojo.Resturant;
import typhoon.merchant.pojo.User;
import typhoon.merchant.service.impl.AdvertisementServiceImpl;
import typhoon.merchant.service.impl.ResturantServiceImpl;
import typhoon.merchant.util.UUIDUtil;
/**
 * 
 * @author GAOJO2
 *
 */
public class UpdateRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResturantServiceImpl impl;
    public UpdateRestaurantServlet() {
        super();
    }
    @Override
    public void init() throws ServletException {
    	super.init();
    	impl = ResturantServiceImpl.getInstance();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("------------------------UpdateRestaurantServlet------------------------------");

		HttpSession sen = request.getSession();
		User user =(User) sen.getAttribute("user");
		FileUpload upload = new FileUpload(new DiskFileItemFactory());
		List<FileItem> fileItems = null;
		String openTime = null;
		String closeTime = null;
		Double delivery = 0.0;
		Double deliFee = 0.0;
		String picture= null;
		String comments= null;
		String slogan= null;
		String shopId= user.getShopId();
		
		try {
			fileItems = upload.parseRequest(new ServletRequestContext(request));
			for(FileItem fileItem:fileItems) {
				if(fileItem.isFormField()) {
					if (fileItem.getFieldName().equals("openTime")) {
						openTime = fileItem.getString();
					} else if (fileItem.getFieldName().equals("closeTime")) {
						closeTime = fileItem.getString();
					} else if (fileItem.getFieldName().equals("delivery")) {
						delivery = Double.valueOf(fileItem.getString());
					} else if (fileItem.getFieldName().equals("deliFee")) {
						deliFee = Double.valueOf(fileItem.getString());
					} else if (fileItem.getFieldName().equals("slogan")) {
						slogan = fileItem.getString();
					} else if (fileItem.getFieldName().equals("comments")) {
						comments = fileItem.getString();
					}
				}else {
					if(fileItem.getName()!="") {
						byte[] buf = fileItem.get();
						String fileName = UUIDUtil.uuid32()+fileItem.getName();;
						OutputStream out = new FileOutputStream(
								this.getServletContext().getRealPath("/img") + "/" + fileName);
						System.out.println(this.getServletContext().getRealPath("/img") + "/" + fileName);
						picture = "img/" + fileName;
						out.write(buf);
						out.close();
					}else {
						picture =(String)request.getAttribute("picture");
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		impl.updateResturant(new Resturant(shopId, openTime, closeTime, delivery, deliFee, picture, slogan, 0, comments));
	//	request.getRequestDispatcher("ShowRestaurantDetailServlet").forward(request, response);
	}

}
