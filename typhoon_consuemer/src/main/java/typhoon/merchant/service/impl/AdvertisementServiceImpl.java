package typhoon.merchant.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;

import typhoon.merchant.dao.impl.AdvertisementDaoImpl;
import typhoon.merchant.dao.impl.ResturantDaoImpl;
import typhoon.merchant.pojo.Advertisement;
import typhoon.merchant.service.AdvertisementService;
import typhoon.merchant.util.DBUtil;
import typhoon.merchant.util.JmsUtil;
import typhoon.merchant.util.JsonParseByJackson;
/**
 * 
 * @author GAOJO2
 *
 */
public class AdvertisementServiceImpl implements AdvertisementService {
	private static AdvertisementServiceImpl instance;
	private AdvertisementDaoImpl impl;
    private AdvertisementServiceImpl(){
        initData();
    }
    public static AdvertisementServiceImpl getInstance(){
        if(instance==null){
            synchronized (AdvertisementServiceImpl.class){
                if(instance==null){
                    instance=new AdvertisementServiceImpl();
                }
            }
        }
        return instance;
    }
    public void initData() {
    	impl = new AdvertisementDaoImpl(); 
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
		List<Advertisement> list = impl.findAllAd(shopId);
		return list;
	}

	public int updateAd(Advertisement ad) {
		return impl.updateAd(ad);
	}

	public int sendAdInfoToAdmin(Advertisement ad) {
		try {
			Properties conf = new Properties(); 
			try {
				conf.load(new FileInputStream(getRealPath("dbconf.properties")));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Destination queue = new ActiveMQQueue(conf.getProperty("queueName"));
			Session sen1 = JmsUtil.getSession(false, Session.CLIENT_ACKNOWLEDGE);
			MessageProducer producer = sen1.createProducer(queue);
			JsonParseByJackson<Advertisement> parse = new JsonParseByJackson<Advertisement>();
			String json = parse.parseObjectToJson(ad);
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
		return impl.loadAd(id);
	}
	private static String getRealPath(String filePath) {
    	System.out.println(DBUtil.class.getResource("/" + filePath).toString().substring(6));
    	return DBUtil.class.getResource("/" + filePath).toString().substring(6);
    }
}
