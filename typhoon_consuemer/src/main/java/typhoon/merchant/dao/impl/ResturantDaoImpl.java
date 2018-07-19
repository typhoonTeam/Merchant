package typhoon.merchant.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import typhoon.merchant.dao.ResturantDao;
import typhoon.merchant.pojo.Resturant;
import typhoon.merchant.pojo.User;
import typhoon.merchant.util.DBUtil;

public class ResturantDaoImpl implements ResturantDao {
	// @Override
	public int updateResturant(Map<String, String> data) {
		int m = 0;
		PreparedStatement pStatement = null;
		Connection con = DBUtil.getConnection();
		Set<String> key = data.keySet();
		String id = null;
		for (String k : key) {
			if (k.equals("shop_id")) {
				id = data.get(k);
				break;
			}
		}
		StringBuilder sql1 = new StringBuilder();
		String[] sort = new String[key.size()];
		sql1.append("update restaurant set ");
		int i = 0;
		for (String k : key) {
			sort[i] = k;
			i++;
		}

		for (int j = 0; j < i; j++) {
			if (!sort[j].equals("shop_id")) {
				sql1.append(sort[j]);
				sql1.append("='");
				sql1.append(data.get(sort[j]));
				sql1.append("'");
				if (j < i - 1)
					sql1.append(",");
			}
		}
		sql1.append(" where shop_id='");
		sql1.append(data.get("shop_id"));
		sql1.append("'");
		System.out.println(sql1.toString());

		try {
			pStatement = con.prepareStatement(sql1.toString());
			m = pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(con, pStatement, null);
		}
		return m;
	}

	// @Override
	public Resturant findResturant(String shopId) {
		String sql = "select * from restaurant where shop_id=?";
		Resturant m = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection con = DBUtil.getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, shopId);
			pst.executeQuery();
			rs = pst.getResultSet();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {

			if (rs.next() == false) {
				// m = new Resturant(shopId,"","",0.0,0.0,"","",0,"");
			} else {

				m = new Resturant(rs.getString("shop_id"), rs.getString("open_time"), rs.getString("close_time"),
						rs.getDouble("delivery"), rs.getDouble("deli_fee"), rs.getString("picture"),
						rs.getString("slogan"), Integer.valueOf(rs.getInt("status")), rs.getString("comments"));
			}

			// System.out.println(m.toString());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtil.close(con, pst, rs);
		}
		return m;
	}

	public int addResturant(String shopId) {
		int m = 0;
		String sql = "insert into restaurant(shop_id,open_time,close_time,delivery,deli_fee,picture,slogan,status,comments) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection con = DBUtil.getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, shopId);
			pst.setString(2, "0");
			pst.setString(3, "24");
			pst.setString(4, "100");
			pst.setString(5, "100");
			pst.setString(6, "img/default.jpg");
			pst.setString(7, "");
			pst.setString(8, "0");
			pst.setString(9, "");
			m = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(con, pst, rs);
		}

		return m;
	}

}
