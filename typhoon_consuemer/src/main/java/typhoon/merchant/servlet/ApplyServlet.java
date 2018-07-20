package typhoon.merchant.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
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

import typhoon.merchant.pojo.Advertisement;
import typhoon.merchant.pojo.User;
import typhoon.merchant.service.impl.AdvertisementServiceImpl;
import typhoon.merchant.util.ImgUtil;
import typhoon.merchant.util.UUIDUtil;
/**
 * 
 * @author GAOJO2
 *
 */
public class ApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdvertisementServiceImpl service;   
    public ApplyServlet() {
        super();
        }
    @Override
    public void init() throws ServletException {
    	super.init();
    	service = AdvertisementServiceImpl.getInstance();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession();
		User user =(User) sen.getAttribute("user");
		String shopId = user.getShopId();
		FileUpload upload = new FileUpload(new DiskFileItemFactory());
		List<FileItem> fileItems = null;
		String slogan = null;
		Date time = null;
		String picture = null;
		String picture2 = null;
		Double price = null;
		ImgUtil imgUtil = new ImgUtil();
		try {
			fileItems = upload.parseRequest(new ServletRequestContext(request));
			for(FileItem fileItem:fileItems) {
				if(fileItem.isFormField()) {
					if (fileItem.getFieldName().equals("slogan")) {
						slogan = new String(fileItem.getString().getBytes("iso8859-1"), "UTF-8");
					} else if (fileItem.getFieldName().equals("time")) {
						time = Date.valueOf(new String(fileItem.getString().getBytes("iso8859-1"), "UTF-8"));
					}else if (fileItem.getFieldName().equals("price")) {
						price = Double.valueOf(new String(fileItem.getString().getBytes("iso8859-1"), "UTF-8"));
					}
				}else {
					InputStream in = fileItem.getInputStream();
					picture = imgUtil.img2String(in);
					byte[] buf = fileItem.get();
					String fileName = UUIDUtil.uuid32()+fileItem.getName();;
					OutputStream out = new FileOutputStream(
							this.getServletContext().getRealPath("/img") + "/" + fileName);
					System.out.println("获取到图片的储存路径："+this.getServletContext().getRealPath("/img") + "/" + fileName);
					picture2 = "img/" + fileName;
					out.write(buf);
					out.close();
				}
		    } 
		}catch (FileUploadException e) {
			e.printStackTrace();
		}
		Advertisement ad1 = new Advertisement(shopId, picture, slogan,price, 0, time);
		Advertisement ad2 = new Advertisement(shopId, picture2, slogan,price, 0, time);
	    service.addAd(ad2);
		service.sendAdInfoToAdmin(ad1);
		request.getRequestDispatcher("ShowFoodsServlet").forward(request, response);
    }
}
