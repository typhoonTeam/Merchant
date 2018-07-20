package typhoon.merchant.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.List;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import typhoon.merchant.dao.impl.AdvertisementDaoImpl;
import typhoon.merchant.dao.impl.ResturantDaoImpl;
import typhoon.merchant.pojo.Advertisement;
import typhoon.merchant.pojo.RegisterInfo;
import typhoon.merchant.pojo.Resturant;
import typhoon.merchant.pojo.User;
import typhoon.merchant.service.AdvertisementService;
import typhoon.merchant.service.impl.AdvertisementServiceImpl;
import typhoon.merchant.util.ImgUtil;
import typhoon.merchant.util.JmsUtil;
import typhoon.merchant.util.JsonParse;
import typhoon.merchant.util.JsonParseByJackson;
import typhoon.merchant.util.SendMsgWithJMS;
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
		Double price = null;
		try {
			fileItems = upload.parseRequest(new ServletRequestContext(request));
			for(FileItem fileItem:fileItems) {
				if(fileItem.isFormField()) {
					if (fileItem.getFieldName().equals("slogan")) {
						slogan = fileItem.getString();
					} else if (fileItem.getFieldName().equals("time")) {
						System.out.println(fileItem.getFieldName());
						time = Date.valueOf(fileItem.getString());
					}else if (fileItem.getFieldName().equals("price")) {
						price = Double.valueOf(fileItem.getString());
					}
				}else {
					InputStream in = fileItem.getInputStream();
					picture = ImgUtil.img2String(in);
				}
		    } 
		}catch (FileUploadException e) {
			e.printStackTrace();
		}

		Advertisement ad = new Advertisement(shopId, picture, slogan,price, 0, time);
	   // service.updateAd(ad);
		service.sendAdInfoToAdmin(ad);
		request.getRequestDispatcher("foods.jsp").forward(request, response);
    }
}
