package typhoon.merchant.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import typhoon.merchant.pojo.Food;
import typhoon.merchant.pojo.User;
import typhoon.merchant.service.FoodService;
import typhoon.merchant.service.impl.FoodServiceImpl;
import typhoon.merchant.util.JsonParse;
import typhoon.merchant.util.JsonParseByJackson;

/**
 * Servlet implementation class FoodDetailServlet
 */
public class FoodDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FoodService foodService = FoodServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Food food = foodService.FindFoodById(id);
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", -10);
		PrintWriter out = response.getWriter();
		JsonParse<Food> jsonUtil = new JsonParseByJackson();
		String result = jsonUtil.parseObjectToJson(food);
		out.print(result);
		System.out.println(result);
		out.flush();
//		request.setAttribute("food", food);
//		request.getRequestDispatcher("foodDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
