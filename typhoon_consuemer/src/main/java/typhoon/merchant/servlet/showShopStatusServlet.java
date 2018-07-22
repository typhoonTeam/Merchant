package typhoon.merchant.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import typhoon.merchant.pojo.User;
import typhoon.merchant.service.UserService;
import typhoon.merchant.service.impl.UserServiceImpl;
import typhoon.merchant.util.JsonOutUtil;
import typhoon.merchant.util.JsonParse;
import typhoon.merchant.util.JsonParseByJackson;

/**
 * Servlet implementation class showShopStatusServlet
 */
public class showShopStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = UserServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("------------------------showShopStatusServlet------------------------------");
		User user = (User) request.getSession().getAttribute("user");
		// int checkStatus =
		int checkStatus = userService.receiveCheckStatus(user.getShopId());//返回从A端获得的店铺状态
		JsonOutUtil jsonOutUtil = new JsonOutUtil();
		// jsonOutUtil.outJson(request, response,
		// (Integer)checkStatus);//[{checkStatus:2}]
		// jsonOutUtil.outJson(response, true);

		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", -10);
		PrintWriter out = response.getWriter();
		// ObjectMapper mapper=new ObjectMapper();
		// String jsonStr=mapper.writeValueAsString();
//		JsonParse<User> jsonUtil = new JsonParseByJackson<>();
//		String result = jsonUtil.parseObjectToJson(new User("fadsj", "kfsjd", "dfklsj"));
		// String parseListToJson = jsonUtil.parseListToJson(new ArrayList<>());
//		out.print(result);
		System.out.println("{\"checkStatus\":\""+checkStatus+"\"}");
		out.print("{\"checkStatus\":\""+checkStatus+"\"}");
//		System.out.println(result);
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
