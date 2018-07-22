package typhoon.merchant.dao;

/**
 * @author GAOJO2
 */
import java.util.List;
import java.util.Map;

import typhoon.merchant.pojo.Food;

public interface FoodDao {
	public int addFood(Food food);

	public List<Food> findAllFood();

	public int updateFood(Map<String, String> data);

	public void updateFood(Food food);

	public int delete(Integer foodId);

	public List<Food> findFoodByShopId(String id);

	public Food findFoodById(int id);

	public int findFoodCount(String shopId);

	public List<Food> getFoodByPage(int begin, int i,String shopId);
}
