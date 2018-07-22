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
/**
 * 
 * @author GAOJO2
 *
 */
public class ResturantDaoImpl implements ResturantDao{
//	@Override
	public int updateResturant(Resturant resturant) {
		int m=0;
		PreparedStatement pStatement = null;
		Connection con = DBUtil.getConnection();
		String sql = "update restaurant set open_time=?,close_time=?,delivery=?,deli_fee=?,"
				+ "picture=?,slogan=?,comments=? where shop_id=?";
		try {
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1,resturant.getOpenTime());
			pStatement.setString(2,resturant.getCloseTime());
			pStatement.setDouble(3,resturant.getDelivery());
			pStatement.setDouble(4,resturant.getDeliFee());
			pStatement.setString(5,resturant.getPicture());
			pStatement.setString(6,resturant.getSlogan());
			pStatement.setString(7,resturant.getComments());
			pStatement.setString(8,resturant.getShopId());
			m = pStatement.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(con, pStatement, null);
		}
		return m;
	}
//	@Override
	public Resturant findResturant(String shopId) {
		String sql = "select * from restaurant where shop_id=?";
		Resturant m = null;
		PreparedStatement pst= null;
		ResultSet rs = null;
		Connection con = DBUtil.getConnection();
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, shopId);
			pst.executeQuery();
			rs = pst.getResultSet();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
		    if(rs.next()==false) {
		    }else {
		    	m = new Resturant(rs.getString("shop_id"),rs.getString("open_time"),rs.getString("close_time"),rs.getDouble("delivery"),rs.getDouble("deli_fee"),
						rs.getString("picture"),rs.getString("slogan"),Integer.valueOf(rs.getInt("status")),rs.getString("comments"));
		    }
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(con, pst, rs);
		}
		return m;
	}
	
	public int addDefaultResturant(String shopId) {
		int m=0;
			String sql = "insert into restaurant(shop_id,open_time,close_time,delivery,deli_fee,picture,slogan,status,comments) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst= null;
			ResultSet rs = null;
			Connection con = DBUtil.getConnection();
			try {
				pst=con.prepareStatement(sql);
				pst.setString(1, shopId);
				pst.setString(2, "08:00");
				pst.setString(3, "20:00");
				pst.setString(4, "10.0");
				pst.setString(5, "10.0");
				pst.setString(6, "image/default.png");
				pst.setString(7, "");
				pst.setString(8, "0");
				pst.setString(9, "");
				m = pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.close(con, pst, rs);
			}
			return m;
		}
}
