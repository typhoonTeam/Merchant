package typhoon.merchant.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import typhoon.merchant.pojo.User;
import typhoon.merchant.service.UserService;
import typhoon.merchant.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = UserServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("i am get!");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + "\t" + password);
		int status = userService.checkUserLogin(username, password);
		response.setHeader("content-Type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		if (status == 1) {
			System.out.println("登录成功");
			User user = userService.findUser(username);
			request.getSession().setAttribute("user", user);
			int checkStatus = userService.receiveCheckStatus(user.getShopId());
			if (checkStatus == 0) {
				// request.setAttribute("status","待审核");
				request.getRequestDispatcher("checking.jsp").forward(request, response);
				System.out.println("待审核");
			} else if (checkStatus == 1) {
				// request.setAttribute("status","通过");
				request.setAttribute("checkStatus", checkStatus);
				request.getSession().setAttribute("checkStatus", checkStatus);
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
				// System.out.println("通过");
			} else if (checkStatus == 2) {// 驳回
				request.getRequestDispatcher("reject.jsp").forward(request, response);
				// request.setAttribute("status","不通过");
				System.out.println("驳回");
			} else if (checkStatus == 3) {
				request.getRequestDispatcher("noPass.jsp").forward(request, response);
				request.setAttribute("status", "不通过");
				System.out.println("不通过");
			}

			// response.getWriter().print("<script
			// language='javascript'>alert('登录成功');window.location.href='welcome.jsp';</script>");
		} else if (status == 0) {
			System.out.println("没有该账号 ：" + username);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			// response.getWriter().print("<script
			// language='javascript'>alert('没有该账号');window.location.href='login.jsp';</script>");
		} else if (status == -1) {
			System.out.println("密码错误 :" + username);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			// response.getWriter().print("<script
			// language='javascript'>alert('密码错误');window.location.href='login.jsp';</script>");
		}
	}

}
