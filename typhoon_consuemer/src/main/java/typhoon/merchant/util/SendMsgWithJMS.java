package typhoon.merchant.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import typhoon.merchant.pojo.RegisterInfo;

public class SendMsgWithJMS {
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

	public static int send(RegisterInfo message, String queueName) {
		String jms = conf.getProperty("jmsIP");
		ConnectionFactory factory = new ActiveMQConnectionFactory(jms);
		try {
			Connection con = factory.createConnection();
			Destination queue = new ActiveMQQueue(queueName);
			Session sen = con.createSession(false, Session.CLIENT_ACKNOWLEDGE);
			MessageProducer producer = sen.createProducer(queue);
			// 改为使用json解析工具
			JsonParse<RegisterInfo> jsonUtil = new JsonParseByJackson<RegisterInfo>();
			String jsonMsg = jsonUtil.parseObjectToJson(message);

			TextMessage msg = sen.createTextMessage(jsonMsg);
			msg.acknowledge();
			producer.send(msg);
			producer.close();
			con.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return 1;
	}
}
