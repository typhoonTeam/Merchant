package typhoon_merchant;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import typhoon.merchant.service.impl.AdvertisementServiceImpl;
/**
 * 
 * @author GAOJO2
 *
 */
public class AdvertisementServiceImplTest {
	static AdvertisementServiceImpl imp;
	@BeforeClass
	public static void init() {
		imp = AdvertisementServiceImpl.getInstance();
	}
//	@Test
//	public void testSendWithJms() {
//	  int m=imp.sendAdInfoToAdmin("429c12d1d19644a9a183daea4c3dcb76");
//		Assert.assertTrue(m>0);
//	}
}
