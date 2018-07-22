package typhoon.merchant.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import typhoon.merchant.pojo.Food;
import typhoon.merchant.pojo.Page;
import typhoon.merchant.pojo.User;
import typhoon.merchant.service.FoodService;
import typhoon.merchant.service.impl.FoodServiceImpl;
import typhoon.merchant.util.JsonParse;
import typhoon.merchant.util.JsonParseByJackson;

/**
 * Servlet implementation class ShowFood
 */
public class ShowFoodsServletbyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FoodService foodService=FoodServiceImpl.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user  = (User) request.getSession().getAttribute("user");
System.out.println("--------------------ShowFoodsServletbyPage.java------------------------");
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		System.out.println(currentPage+"\t" + pageSize);
		Page<Food> foods=foodService.getFoodByPage(currentPage,pageSize,user.getShopId());
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", -10);
		PrintWriter out=response.getWriter();
		ObjectMapper mapper=new ObjectMapper();
		String jsonStr=mapper.writeValueAsString(foods);
		System.out.println(jsonStr);
		out.print(jsonStr);
        out.flush();
	}

}
