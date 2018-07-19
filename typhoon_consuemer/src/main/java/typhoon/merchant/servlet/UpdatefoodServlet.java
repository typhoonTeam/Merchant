package typhoon.merchant.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import typhoon.merchant.pojo.User;
import typhoon.merchant.service.FoodService;
import typhoon.merchant.service.impl.FoodServiceImpl;
import typhoon.merchant.util.FileUtil;

/**
 * Servlet implementation class UpdatefoodServlet
 */
public class UpdatefoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FileUtil fileUtil = new FileUtil();
	FoodService foodService = FoodServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("user");
		String shopId = user.getShopId();
		request.setCharacterEncoding("UTF-8");
		foodService.UpdateFood(request, this.getServletContext().getRealPath("/img"), shopId);
		request.getRequestDispatcher("ShowFoodsServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
