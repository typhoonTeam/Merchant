package typhoon.merchant.service;

import typhoon.merchant.pojo.Resturant;
/**
 * 
 * @author GAOJO2
 *
 */
public interface ResturantService {
	public Resturant findResturant(String shopId);
	public int updateResturant(Resturant resturant);
	public int addDefaultResturant(String shopId);
}
