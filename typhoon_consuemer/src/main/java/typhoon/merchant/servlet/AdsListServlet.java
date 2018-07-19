package typhoon.merchant.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import typhoon.merchant.dao.impl.AdvertisementDaoImpl;
import typhoon.merchant.pojo.Advertisement;
import typhoon.merchant.pojo.User;
import typhoon.merchant.service.impl.AdvertisementServiceImpl;
/**
 * 
 * @author GAOJO2
 *
 */
public class AdsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AdvertisementServiceImpl impl;   
    public AdsListServlet() {
        super();
    }
    @Override
    public void init() throws ServletException {
    	super.init();
    	impl = AdvertisementServiceImpl.getInstance();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession();
		User user =(User) sen.getAttribute("user");
		request.setAttribute("ads", impl.findAllAds(user.getShopId()));
		request.getRequestDispatcher("adList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
