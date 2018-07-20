package typhoon.merchant.service;
/**
 * @author GAOJO2
 */
import java.util.List;

import typhoon.merchant.pojo.Advertisement;

public interface AdvertisementService {
	public int addAd(Advertisement ad);
	public List<Advertisement> findAllAds(String shopId);
	public int deleteAd(Integer id);
	public int updateAd(Advertisement ad);
	public int sendAdInfoToAdmin(Advertisement ad);
	public Advertisement loadAd(Integer id);
}
