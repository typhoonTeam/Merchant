package typhoon_merchant;

import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.Assert;

import java.sql.Date;
import java.util.List;

import typhoon.merchant.dao.impl.AdvertisementDaoImpl;
import typhoon.merchant.pojo.Advertisement;
/**
 * 
 * @author GAOJO2
 *
 */
public class AdvertisementDaoImplTest {
	static AdvertisementDaoImpl impl;
	@BeforeClass
	public static void init() {
		impl = new AdvertisementDaoImpl();
	}
	@Test
	public void testAddAd() {
		Advertisement ad = new Advertisement("429c12d1d19644a9a183daea4c3dcb76", "test","www.xx.com", "gogogo", 11.2,0, new Date(19911211));
		int m = impl.addAd(ad);
		Assert.assertTrue(m>0);
	}
	@Test
	public void testDeleteAd() {
		int m=0;
		m = impl.deleteAd(6);
		Assert.assertTrue(m>0);
	}
	@Test
	public void testUpdateAd() {
		int m = 0;
		Advertisement ad = new Advertisement("0b8cf80645a042e185c8ab9f59a1d734","test","http://10.222.29.191:9090/typhoon_merchant/img/1123.jpg", "黄焖鸡米饭开张了！首天开张通通5折", 11.2,0, new Date(19911112));
		ad.setId(5);
		m = impl.updateAd(ad);
		Assert.assertTrue(m>0);
	}
	@Test
	public void testfindAllAds() {
		List<Advertisement> list;
		list = impl.findAllAd("0b8cf80645a042e185c8ab9f59a1d734");
		for (Advertisement a : list) {
			System.out.println(a.toString());
		}
		Assert.assertTrue(list!=null);
		Assert.assertTrue(!list.isEmpty());
	}
	
}
