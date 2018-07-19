package typhoon_merchant;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import typhoon.merchant.util.HttpUtil;

public class HttpTest {
	@Test
	public void test() throws MalformedURLException, IOException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("queryStatus", "123");
		HttpUtil httpUtil = new HttpUtil();
		String receive = httpUtil.send(new URL("http://10.222.29.190:8090/team_typhoon_admin/StatusCheck"),map);
		System.out.println(receive);
	}
}
