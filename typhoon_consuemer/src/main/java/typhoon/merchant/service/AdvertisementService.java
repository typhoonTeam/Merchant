package typhoon.merchant.service;

import java.util.List;

import typhoon.merchant.pojo.Advertisement;

public interface AdvertisementService {
	public int addAd(Advertisement ad);
	public List<Advertisement> findAllAds(String shopId);
	public int deleteAd(Integer id);
	public int updateAd(Advertisement ad);
	public int sendAdInfoToAdmin(String shopId);
	public Advertisement loadAd(Integer id);
}
