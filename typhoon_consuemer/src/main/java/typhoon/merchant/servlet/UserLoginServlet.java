package typhoon.merchant.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import typhoon.merchant.pojo.RegisterInfo;
import typhoon.merchant.pojo.User;
import typhoon.merchant.service.RegisterInfoService;
import typhoon.merchant.service.ResturantService;
import typhoon.merchant.service.UserService;
import typhoon.merchant.service.impl.RegisterInfoServiceImpl;
import typhoon.merchant.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = UserServiceImpl.getInstance();
	RegisterInfoService registerInfoService = RegisterInfoServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + "\t" + password);
		int status = userService.checkUserLogin(username, password);
		
//		response.setContentType("text/html;charset=UTF-8");
//		response.setHeader("Pragma", "No-cache");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setDateHeader("Expires", -10);
//		PrintWriter out = response.getWriter();
		if (status == 1) {
			System.out.println("登录成功");
			User user = userService.findUser(username);
			RegisterInfo registerInfo = registerInfoService.findRegisterInfoByShopId(user.getShopId());
			request.getSession().setAttribute("user", user);
			response.sendRedirect("index.html");

		} else if (status == 0) {
			System.out.println("没有该账号 ：" + username);
//			response.sendRedirect("login.html");
			response.getWriter().print(
					"<script language='javascript'>alert('this merchant can not be found');window.location.href='login.html';</script>");
		} else if (status == -1) {
			System.out.println("密码错误 :" + username);
//			response.sendRedirect("login.html");
			response.getWriter().print(
					"<script language='javascript'>alert('wrong password');window.location.href='login.html';</script>");
		}
//		if (status == 1) {
//			System.out.println("登录成功");
//			User user = userService.findUser(username);
//			RegisterInfo registerInfo = registerInfoService.findRegisterInfoByShopId(user.getShopId());
//			request.getSession().setAttribute("user", user);
//			out.print("{\"status\":\""+1+"\"}");
//
//		} else if (status == 0) {
//			System.out.println("没有该账号 ：" + username);
//			out.print("{\"status\":\""+0+"\"}");
//		} else if (status == -1) {
//			System.out.println("密码错误 :" + username);
//			out.print("{\"status\":\""+(-1)+"\"}");
			// response.getWriter().print("<script
			// language='javascript'>alert('密码错误');window.location.href='login.jsp';</script>");
		
	}

}
