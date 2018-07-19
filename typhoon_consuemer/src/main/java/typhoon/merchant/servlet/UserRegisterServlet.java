package typhoon.merchant.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import typhoon.merchant.pojo.User;
import typhoon.merchant.service.UserService;
import typhoon.merchant.service.impl.UserServiceImpl;

public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = UserServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + "\t" + password);
		User user = new User(username, password);
		System.out.println("reg :" + user.getShopId());
		int adduserStatus = userService.addUser(user);
		if (adduserStatus == 0) {
			response.getWriter().print(
					"<script language='javascript'>alert('this username has be registered');window.location.href='register.jsp';</script>");
			// request.getRequestDispatcher("register.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("CompleteRegisterInfo.jsp").forward(request, response);
		}
		// doGet(request, response);
	}

}
