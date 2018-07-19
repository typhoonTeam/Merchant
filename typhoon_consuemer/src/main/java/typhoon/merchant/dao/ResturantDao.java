package typhoon.merchant.dao;
/**
 * @author GAOJO2
 */
import java.util.Map;

import typhoon.merchant.pojo.Resturant;

public interface ResturantDao {
	public int updateResturant(Resturant resturant);
	public Resturant findResturant(String shopId);
	public int addDefaultResturant(String shopId);
}
