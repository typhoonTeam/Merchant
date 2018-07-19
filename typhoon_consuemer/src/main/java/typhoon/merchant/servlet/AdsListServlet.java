package typhoon.merchant.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import typhoon.merchant.dao.impl.AdvertisementDaoImpl;
import typhoon.merchant.pojo.Advertisement;
import typhoon.merchant.pojo.User;
import typhoon.merchant.service.impl.AdvertisementServiceImpl;

/**
 * Servlet implementation class AdsListServlet
 */
public class AdsListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdvertisementServiceImpl impl = AdvertisementServiceImpl.getInstance();
		HttpSession sen = request.getSession();
		User user = (User) sen.getAttribute("user");
		request.setAttribute("ads", impl.findAllAds(user.getShopId()));
		request.getRequestDispatcher("adList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
