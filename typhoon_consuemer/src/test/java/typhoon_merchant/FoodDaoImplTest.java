package typhoon_merchant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import typhoon.merchant.dao.impl.FoodDaoImpl;
import typhoon.merchant.pojo.Food;
/**
 * 
 * @author GAOJO2
 *
 */
public class FoodDaoImplTest {
	static FoodDaoImpl foodDaoImpl;
	@BeforeClass
	public static void init() {
		foodDaoImpl = new FoodDaoImpl();
	}
	@Test
	public void testUpdateFood() {
		Map<String, String> data = new HashMap<String,String>();
		data.put("id","3");
		data.put("food_name","cloo");
		data.put("price","123");
		data.put("picture","ww.com");
		data.put("info","ook");
		data.put("status","2");
		data.put("shop_id","c4e88edc49af4bd18b112982f46be424");
		foodDaoImpl.updateFood(data);
	}
	@Test
	public void testAddFood() {
		int m = 0;
		Food food = new Food("oocl",11.2,"ttt.com","ook","3","c4e88edc49af4bd18b112982f46be424");
		m = foodDaoImpl.addFood(food);
		Assert.assertTrue(m>0);
	}
	@Test
	public void testDeleteFood() {
		int m = 0;
		m = foodDaoImpl.delete(3);
		Assert.assertTrue(m>0);
	}
	@Test
	public void testFindAllFood() {
		List<Food> fList = foodDaoImpl.findAllFood();
		Assert.assertTrue(fList!=null);
		Assert.assertTrue(!fList.isEmpty());
	}
}
