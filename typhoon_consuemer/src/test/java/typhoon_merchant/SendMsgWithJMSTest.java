package typhoon_merchant;

import org.junit.Test;

import typhoon.merchant.pojo.RegisterInfo;
import typhoon.merchant.util.SendMsgWithJMS;

public class SendMsgWithJMSTest {
	@Test
	public void test() {
		
		RegisterInfo info = new RegisterInfo("123", "123", "123","123", "123","123", "123","123");
		SendMsgWithJMS.send(info,"AMCQ2");
		
//		10.222.29.189:61616  queue=jasonQ
	}
}
