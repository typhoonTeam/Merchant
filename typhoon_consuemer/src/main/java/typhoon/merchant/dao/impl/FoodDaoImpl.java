package typhoon.merchant.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import typhoon.merchant.dao.FoodDao;
import typhoon.merchant.pojo.Food;
import typhoon.merchant.pojo.User;
import typhoon.merchant.util.DBUtil;
/**
 * 
 * @author GAOJO2
 *
 */
public class FoodDaoImpl implements FoodDao {
	String sql = null;

	// @Override
	public int addFood(Food food) {
		int num = 0;
		sql = "INSERT INTO food(id,food_name,price,picture,info,status,shop_id) VALUES (food_seq.nextval,?,?,?,?,?,?)";
		PreparedStatement pStatement = null;
		Connection con = DBUtil.getConnection();
		try {
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, food.getFoodName());
			pStatement.setDouble(2, food.getPrice());
			pStatement.setString(3, food.getPicture());
			pStatement.setString(4, food.getInfo());
			pStatement.setString(5, food.getStatus());
			pStatement.setString(6, food.getShopId());
			num = pStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pStatement, null);
		}
		return num;
	}

	public List<Food> findAllFood() {
		List<Food> list = new ArrayList<Food>();
		ResultSet rs = null;
		Food food = null;
		PreparedStatement pStatement = null;
		sql = "select * from food";
		Connection con = DBUtil.getConnection();
		try {
			pStatement = con.prepareStatement(sql);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("food_name"));
				food = new Food(rs.getString("food_name"), Double.valueOf(rs.getString("price")),
						rs.getString("picture"), rs.getString("info"), rs.getString("status"), rs.getString("shop_id"));
				;
				food.setId(Integer.valueOf(rs.getString("id")));
				list.add(food);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pStatement, rs);
		}
		return list;
	}

	public void updateFood(Food food) {
		int num = 0;
		sql = "UPDATE food SET food_Name = ? , price = ?,picture = ?,info =?,status=?,shop_Id=? WHERE id = ?";
		ResultSet rs = null;
		PreparedStatement pStatement = null;
		Connection con = DBUtil.getConnection();
		// private int id;
		// private String foodName;
		// private Double price;
		// private String picture;
		// private String info;
		// private String status;
		// private String shopId;
		try {
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, food.getFoodName());
			pStatement.setDouble(2, food.getPrice());
			pStatement.setString(3, food.getPicture());
			pStatement.setString(4, food.getInfo());
			pStatement.setString(5, food.getStatus());
			pStatement.setString(6, food.getShopId());
			pStatement.setInt(7, food.getId());
			num = pStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pStatement, rs);
		}
	}

	public int updateFood(Map<String, String> data) {
		int m = 0;
		PreparedStatement pStatement = null;
		Connection con = DBUtil.getConnection();
		Set<String> key = data.keySet();
		String id = null;
		for (String k : key) {
			if (k.equals("id")) {
				id = data.get(k);
				break;
			}
		}
		StringBuilder sql1 = new StringBuilder();
		String[] sort = new String[key.size()];
		sql1.append("update food set ");
		int i = 0;
		for (String k : key) {
			sort[i] = k;
			i++;
		}

		for (int j = 0; j < i; j++) {
			if (!sort[j].equals("id")) {
				sql1.append(sort[j]);
				sql1.append("='");
				sql1.append(data.get(sort[j]));
				sql1.append("'");
				if (j < i - 1)
					sql1.append(",");
			}
		}
		sql1.append(" where id='");
		sql1.append(data.get("id"));
		sql1.append("'");
		System.out.println(sql1.toString());

		try {
			pStatement = con.prepareStatement(sql1.toString());
			m = pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pStatement, null);
		}
		return m;
	}

	public int delete(Integer foodId) {
		int m = 0;
		sql = "delete from food where id=?";
		PreparedStatement pStatement = null;
		Connection con = DBUtil.getConnection();
		try {
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, foodId.toString());
			m = pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pStatement, null);
		}

		return m;
	}

	public List<Food> findFoodByShopId(String shopId) {
		System.out.println("shopId:" + shopId);
		List<Food> list = new ArrayList<Food>();
		ResultSet rs = null;
		Food food = null;
		PreparedStatement pStatement = null;
		sql = "select * from food where shop_id=?";
		Connection con = DBUtil.getConnection();
		try {
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, shopId);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("food_name"));
				food = new Food(rs.getString("food_name"), Double.valueOf(rs.getString("price")),
						rs.getString("picture"), rs.getString("info"), rs.getString("status"), rs.getString("shop_id"));
				food.setId(Integer.valueOf(rs.getString("id")));
				list.add(food);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pStatement, rs);
		}
		return list;
	}

	public Food findFoodById(int id) {
		ResultSet rs = null;
		Food food = null;
		PreparedStatement pStatement = null;
		sql = "select * from food where id=?";
		Connection con = DBUtil.getConnection();
		try {
			pStatement = con.prepareStatement(sql);
			pStatement.setInt(1, id);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				food = new Food(rs.getString("food_name"), Double.valueOf(rs.getString("price")),
						rs.getString("picture"), rs.getString("info"), rs.getString("status"), rs.getString("shop_id"));
				food.setId(Integer.valueOf(rs.getString("id")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(con, pStatement, rs);
		}
		return food;
	}

	
}
