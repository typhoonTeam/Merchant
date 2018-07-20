package typhoon.merchant.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import typhoon.merchant.dao.impl.ResturantDaoImpl;
import typhoon.merchant.pojo.Resturant;
import typhoon.merchant.pojo.User;
import typhoon.merchant.service.impl.ResturantServiceImpl;
import typhoon.merchant.util.ImgUtil;
import typhoon.merchant.util.UUIDUtil;
/**
 * 
 * @author GAOJO2
 *
 */
public class ShowRestaurantDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    ResturantServiceImpl impl;
    public ShowRestaurantDetailServlet() {
        super();
    }
    @Override
    public void init() throws ServletException {
    	super.init();
    	impl = ResturantServiceImpl.getInstance();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession();
		User user =(User) sen.getAttribute("user");
		System.out.println(user.getShopId());
		Resturant res = impl.findResturant(user.getShopId());
		if(res.getPicture()==null) {
			request.setAttribute("picture", "default.jpg");
		}else {
			request.setAttribute("picture", res.getPicture());
		}
		request.setAttribute("Msg", res);
		request.getRequestDispatcher("updateInfo.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
