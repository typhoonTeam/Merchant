package typhoon.merchant.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import typhoon.merchant.pojo.RegisterInfo;
import typhoon.merchant.pojo.User;
import typhoon.merchant.service.RegisterInfoService;
import typhoon.merchant.service.impl.RegisterInfoServiceImpl;

/**
 * Servlet implementation class ShowRestaurantInfoServlet
 */
public class ShowRestaurantInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RegisterInfoService registerInfoService = RegisterInfoServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("user");

		RegisterInfo registerInfo = registerInfoService.findRegisterInfoByShopId(user.getShopId());
		request.setAttribute("registerInfo", registerInfo);
		request.getRequestDispatcher("showRegisterInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
