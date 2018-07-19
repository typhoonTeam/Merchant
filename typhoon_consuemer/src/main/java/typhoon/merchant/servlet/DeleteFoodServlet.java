package typhoon.merchant.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import typhoon.merchant.service.FoodService;
import typhoon.merchant.service.impl.FoodServiceImpl;

public class DeleteFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FoodService foodService = FoodServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idString = (String) request.getParameter("food_id");
		int id = Integer.parseInt(idString);
		foodService.DeleteFood(id);
		request.getRequestDispatcher("ShowFoodsServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
