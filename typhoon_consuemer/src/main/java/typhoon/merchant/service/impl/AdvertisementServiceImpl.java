package typhoon.merchant.service.impl;

import java.util.List;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;

import typhoon.merchant.dao.impl.AdvertisementDaoImpl;
import typhoon.merchant.dao.impl.FoodDaoImpl;
import typhoon.merchant.pojo.Advertisement;
import typhoon.merchant.service.AdvertisementService;
import typhoon.merchant.util.JmsUtil;

public class AdvertisementServiceImpl implements AdvertisementService {

	private static AdvertisementServiceImpl instance;

	private AdvertisementServiceImpl() {
		initData();
	}

	public static AdvertisementServiceImpl getInstance() {
		if (instance == null) {
			synchronized (AdvertisementServiceImpl.class) {
				if (instance == null) {
					instance = new AdvertisementServiceImpl();
				}
			}
		}
		return instance;
	}

	public void initData() {
	}

	public int addAd(Advertisement ad) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteAd(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Advertisement> findAllAds(String shopId) {
		AdvertisementDaoImpl imp = new AdvertisementDaoImpl();
		List<Advertisement> list = imp.findAllAd(shopId);
		return list;
	}

	public int updateAd(Advertisement ad) {
		AdvertisementDaoImpl impl = new AdvertisementDaoImpl();
		impl.updateAd(ad);
		return 1;
	}

	public int sendAdInfoToAdmin(String shopId) {
		try {
			Destination queue = new ActiveMQQueue("AMCQ");
			Session sen1 = JmsUtil.getSession(false, Session.CLIENT_ACKNOWLEDGE);
			MessageProducer producer = sen1.createProducer(queue);
			String json = "{\"shopId\":\"" + shopId + "\"}";
			System.out.println(json);
			TextMessage msg = sen1.createTextMessage(json);
			msg.acknowledge();
			producer.send(msg);
			JmsUtil.closeResource(sen1, producer, null);
		} catch (JMSException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public Advertisement loadAd(Integer id) {
		AdvertisementDaoImpl imp = new AdvertisementDaoImpl();
		Advertisement res = imp.loadAd(id);
		return res;
	}
}
