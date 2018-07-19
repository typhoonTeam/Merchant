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

/**
 * Servlet implementation class ShowRestaurantDetailServlet
 */
public class ShowRestaurantDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession();
		User user =(User) sen.getAttribute("user");
		System.out.println(user.getShopId());
//		ResturantDaoImpl imp = new ResturantDaoImpl();这段不是我的
//		Resturant res = imp.findResturant(user.getShopId());
//		if(res==null) {
//			imp.addResturant(user.getShopId());
//			res = imp.findResturant(user.getShopId());
//		}
//		request.setAttribute("Msg", res);
		request.getRequestDispatcher("updateInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession();
		request.setCharacterEncoding("UTF-8");
		User user =(User) sen.getAttribute("user");
		ResturantDaoImpl imp = new ResturantDaoImpl();
		Map<String, String> data = new HashMap<String, String>();
		data.put("open_time", request.getParameter("openTime"));
		data.put("close_time", request.getParameter("closeTime"));
		data.put("delivery", request.getParameter("delivery"));
		if(request.getParameter("delivery")==null) {
			data.put("delivery", "0");
		}else {
			data.put("delivery", request.getParameter("delivery"));
		}
		data.put("deli_fee", request.getParameter("deliFee"));
		data.put("comments", request.getParameter("comments"));
		data.put("slogan", request.getParameter("slogan"));
		if(request.getParameter("picture")==null) {
			data.put("picture", " ");
		}else {
			data.put("picture", request.getParameter("picture"));
		}
		
		
		data.put("shop_id", user.getShopId());
		imp.updateResturant(data);
		doGet(request,response);
	//	System.out.println("基本信息修改完成！！");
	}

}
