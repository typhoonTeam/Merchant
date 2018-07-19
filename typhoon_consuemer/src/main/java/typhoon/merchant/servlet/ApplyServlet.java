package typhoon.merchant.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.activemq.command.ActiveMQQueue;

import typhoon.merchant.dao.impl.AdvertisementDaoImpl;
import typhoon.merchant.dao.impl.ResturantDaoImpl;
import typhoon.merchant.pojo.Advertisement;
import typhoon.merchant.pojo.RegisterInfo;
import typhoon.merchant.pojo.Resturant;
import typhoon.merchant.pojo.User;
import typhoon.merchant.service.AdvertisementService;
import typhoon.merchant.service.impl.AdvertisementServiceImpl;
import typhoon.merchant.util.JmsUtil;
import typhoon.merchant.util.JsonParse;
import typhoon.merchant.util.JsonParseByJackson;
import typhoon.merchant.util.SendMsgWithJMS;

/**
 * Servlet implementation class ApplyServlet
 */
public class ApplyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdvertisementServiceImpl service = AdvertisementServiceImpl.getInstance();
		HttpSession sen = request.getSession();
		User user = (User) sen.getAttribute("user");
		System.out.println(user.getShopId());
		Integer id = Integer.valueOf(request.getParameter("ad_id"));
		System.out.println(id);
		sen.setAttribute("adId", id);
		request.setAttribute("ad", service.loadAd(id));
		request.getRequestDispatcher("applyAd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdvertisementServiceImpl service = AdvertisementServiceImpl.getInstance();
		HttpSession sen = request.getSession();
		User user = (User) sen.getAttribute("user");
		Integer id = (Integer) sen.getAttribute("adId");
		String shopId = user.getShopId();
		String picture = request.getParameter("picture");
		String slogan = request.getParameter("slogan");
		int state = Integer.valueOf(request.getParameter("state"));
		Date time = Date.valueOf(request.getParameter("time"));
		Advertisement ad = new Advertisement(shopId, picture, slogan, state, time);
		ad.setId(id);
		service.updateAd(ad);
		service.sendAdInfoToAdmin(shopId);
	}

}
