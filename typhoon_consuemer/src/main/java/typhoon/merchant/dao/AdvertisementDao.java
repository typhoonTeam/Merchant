package typhoon.merchant.dao;
/**
 * @author GAOJO2
 */
import java.util.List;

import typhoon.merchant.pojo.Advertisement;

public interface AdvertisementDao {
	public int addAd(Advertisement ad);

	public int deleteAd(Integer id);

	public int updateAd(Advertisement ad);

	public List<Advertisement> findAllAd(String shopId);

	public Advertisement loadAd(Integer id);
}
