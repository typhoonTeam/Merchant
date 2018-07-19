package typhoon.merchant.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import typhoon.merchant.pojo.Food;
import typhoon.merchant.pojo.User;
import typhoon.merchant.service.FoodService;
import typhoon.merchant.service.impl.FoodServiceImpl;

/**
 * Servlet implementation class ShowFood
 */
public class ShowFoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FoodService foodService = FoodServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");
		String shopId = user.getShopId();
		List<Food> foods = null;
		foods = foodService.findFoodByShopId(shopId);
		request.setAttribute("foods", foods);
		request.getRequestDispatcher("foods.jsp").forward(request, response);
	}

}
