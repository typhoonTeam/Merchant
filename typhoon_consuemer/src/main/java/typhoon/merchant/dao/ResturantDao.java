package typhoon.merchant.dao;

import java.util.Map;

import typhoon.merchant.pojo.Resturant;

public interface ResturantDao {
	public int updateResturant(Map<String, String> data);

	public Resturant findResturant(String shopId);

	public int addResturant(String shopId);
}
