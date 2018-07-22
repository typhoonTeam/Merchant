package typhoon.merchant.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import typhoon.merchant.pojo.Food;
import typhoon.merchant.pojo.Page;

public interface FoodService {
	public List<Food> findFoodByShopId(String shopId);
	public void DeleteFood(int id);
	public Food FindFoodById(int id);
	public Food AddFood(HttpServletRequest request, String path,String shopId);
	public void UpdateFood(HttpServletRequest request, String realPath, String shopId);
	public void updateFood(Food food);
	public void addFood(Food food);
	public Page<Food> getFoodByPage(int currentPage, int pageSize,String shopId);
}
