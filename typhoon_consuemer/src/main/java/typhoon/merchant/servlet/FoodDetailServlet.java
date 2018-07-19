package typhoon.merchant.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import typhoon.merchant.pojo.Food;
import typhoon.merchant.service.FoodService;
import typhoon.merchant.service.impl.FoodServiceImpl;

/**
 * Servlet implementation class FoodDetailServlet
 */
public class FoodDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FoodService foodService = FoodServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("food_id"));
		Food food = foodService.FindFoodById(id);
		request.setAttribute("food", food);
		request.getRequestDispatcher("foodDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
