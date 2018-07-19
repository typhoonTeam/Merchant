package typhoon.merchant.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import typhoon.merchant.dao.impl.ResturantDaoImpl;
import typhoon.merchant.pojo.Resturant;
import typhoon.merchant.pojo.User;
import typhoon.merchant.service.impl.ResturantServiceImpl;
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
		request.setAttribute("Msg", res);
		request.getRequestDispatcher("updateInfo.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession();
		User user =(User) sen.getAttribute("user");
		String openTime = request.getParameter("openTime");
		String closeTime = request.getParameter("closeTime");
		Double delivery = Double.valueOf(request.getParameter("delivery"));
		Double deliFee = Double.valueOf(request.getParameter("deliFee"));
		String picture = request.getParameter("picture");
		String comments = request.getParameter("comments");
		String slogan = request.getParameter("slogan");
		String shopId = user.getShopId();
		impl.updateResturant(new Resturant(shopId, openTime, closeTime, delivery, deliFee, picture, slogan, 0, comments));
	}
}
