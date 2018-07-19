package typhoon.merchant.util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;


public class JmsUtil {
	private JmsUtil() {}
	private static JmsUtil ju;
	
public static Properties conf = new Properties();
	
	static {
		try {
			conf.load(new FileInputStream(getRealPath("ipConfig.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static String getRealPath(String filePath) {
    	System.out.println(DBUtil.class.getResource("/" + filePath).toString().substring(6));
    	return DBUtil.class.getResource("/" + filePath).toString().substring(6);
    }
	public static JmsUtil getJmsUtil(){
		if(ju == null){
			synchronized (JmsUtil.class) {
				if(ju == null){
					ju = new JmsUtil();
				}
			}
		}
		return ju;
	}
	
	private static ConnectionFactory factory;
	private static Connection connection;
//	private static final String URL="tcp://10.222.29.189:61616";
	private static final String URL=conf.getProperty("jmsIP");
	static {
		try {
			factory=new ActiveMQConnectionFactory(URL);
			connection = factory.createConnection();
			connection.start();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	private static Connection getConnection() {
		return connection;
	}
	
	public static Session getSession(boolean transacted,int acknowledgeMode) {
		Session session=null;
		try {
			session=connection.createSession(transacted, acknowledgeMode);
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return session;
	}
	
	public static void closeResource(Session session,MessageProducer producer,MessageConsumer consumer) {
		try {
			if(consumer!=null)consumer.close();
			if(producer!=null)producer.close();
			if(session!=null)session.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
