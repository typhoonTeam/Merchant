package typhoon.merchant.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import typhoon.merchant.pojo.Resturant;
import typhoon.merchant.pojo.User;
import typhoon.merchant.service.impl.ResturantServiceImpl;
import typhoon.merchant.util.JsonParse;
import typhoon.merchant.util.JsonParseByJackson;
/**
 * 
 * @author GAOJO2
 *
 */
public class ShowRestaurantDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    ResturantServiceImpl impl;
    public ShowRestaurantDetailServlet() {
        super();
    }
    @Override
    public void init() throws ServletException {
    	super.init();
    	impl = ResturantServiceImpl.getInstance();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("------------------------ShowRestaurantDetailServlet------------------------------");
		HttpSession sen = request.getSession();
		User user =(User) sen.getAttribute("user");
		Resturant res = impl.findResturant(user.getShopId());
		if(res.getPicture()==null) {
			request.setAttribute("picture", "default.jpg");
		}else {
			request.setAttribute("picture", res.getPicture());
		}
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", -10);
		PrintWriter out=response.getWriter();
		JsonParse<Resturant> jsonUtil=new JsonParseByJackson<>();
		String jsonData = jsonUtil.parseObjectToJson(res);
	//	System.out.println(jsonData);
		out.print(jsonData);
		out.flush();
//		request.setAttribute("Msg", res);
//		request.getRequestDispatcher("updateInfo.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
