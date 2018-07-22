package typhoon.merchant.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import typhoon.merchant.dao.UserDao;
import typhoon.merchant.pojo.User;
import typhoon.merchant.util.DBUtil;

public class UserDaoImpl implements UserDao{
	String sql = null;
	public int addUser(User user) {
		int num = 0;
		sql = "INSERT INTO userinfo(shop_id,username,password) VALUES (?,?,?)";
//		System.out.println(sql);
		ResultSet rs = null;
		PreparedStatement pStatement = null;
		Connection con = DBUtil.getConnection();
		try {
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, user.getShopId());
			pStatement.setString(2, user.getUsername());
			pStatement.setString(3, user.getPassword());
			num = pStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(con, pStatement, rs);
		}
		
		return num;
	}

	public User findUserByUsername(String name){
			ResultSet rs = null;
			User user = null;
//			List<User> books = new ArrayList<Book>();
			PreparedStatement pStatement = null;
			sql = "select * from userinfo where username=?";
			Connection con = DBUtil.getConnection();
			try {
				pStatement = con.prepareStatement(sql);
				pStatement.setString(1, name);
				rs = pStatement.executeQuery();
				while (rs.next()) {
					user = new User(rs.getString("shop_id"), rs.getString("username"), rs.getString("password"));
					System.out.println(rs.getString("shop_id") + "  " + rs.getString("username") + "  " + rs.getString("password"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBUtil.close(con, pStatement, rs);
			}
		return user;
	}

	public int updateUser(User user) {
		int num = 0;
		sql = "UPDATE userinfo SET user_id = ? , price = ? WHERE id = ?";
		ResultSet rs = null;
		PreparedStatement pStatement = null;
		Connection con = DBUtil.getConnection();
		try {
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, user.getShopId());
			pStatement.setString(2, user.getUsername());
			pStatement.setString(3, user.getPassword());
			num = pStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(con, pStatement, rs);
		}
		return num;
		
	}

	@Override
	public int updatePassword(User user) {
		int m = 0;
		sql = "UPDATE userinfo SET password = ? WHERE shop_id = ?";
		PreparedStatement pStatement = null;
		Connection con = DBUtil.getConnection();
		try {
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, user.getPassword());
			pStatement.setString(2, user.getShopId());
			m = pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(con, pStatement, null);
		}
		return m;
	}

	
}
