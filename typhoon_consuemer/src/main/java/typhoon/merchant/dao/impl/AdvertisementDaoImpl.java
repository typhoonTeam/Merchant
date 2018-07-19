package typhoon.merchant.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import typhoon.merchant.dao.AdvertisementDao;
import typhoon.merchant.pojo.Advertisement;
import typhoon.merchant.pojo.Food;
import typhoon.merchant.util.DBUtil;
/**
 * 
 * @author GAOJO2
 *
 */

public class AdvertisementDaoImpl implements AdvertisementDao {
	public int deleteAd(Integer id) {
		int m = 0;
		String sql = "delete from advertisement where id=?";
		PreparedStatement pStatement = null;
		Connection con = DBUtil.getConnection();
		try {
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, id.toString());
			m = pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(con, pStatement, null);
		}
		return m;
	}

	public int addAd(Advertisement ad) {
		int num = 0;
		String sql = "INSERT INTO advertisement(id,shop_id,picture,slogan,state,time) VALUES (ad_seq.nextval,?,?,?,?,?)";
		PreparedStatement pStatement = null;
		Connection con = DBUtil.getConnection();
		try {
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, ad.getShop_id());
			pStatement.setString(2, ad.getPicture());
			pStatement.setString(3, ad.getSlogan());
			pStatement.setInt(4, ad.getState());
			pStatement.setDate(5, ad.getTime());
			num = pStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(con, pStatement, null);
		}
		return num;
	}

	public List<Advertisement> findAllAd(String shopId) {
		List<Advertisement> list = new ArrayList<Advertisement>();
		ResultSet rs = null;
		Advertisement ad = null;
		PreparedStatement pStatement = null;
		String sql = "select * from advertisement";
		Connection con = DBUtil.getConnection();
		try {
			pStatement = con.prepareStatement(sql);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("time"));
				ad = new Advertisement(rs.getString("shop_id"), rs.getString("picture"), rs.getString("slogan"),
						Integer.valueOf(rs.getString("state")), rs.getDate("time"));
				ad.setId(Integer.valueOf(rs.getString("id")));
				list.add(ad);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(con, pStatement, rs);
		}
		return list;
	}

	public int updateAd(Advertisement ad) {
		int num = 0;
		String sql = "update advertisement set picture=?,slogan=?,state=?,time=? where id=?";
		PreparedStatement pStatement = null;
		Connection con = DBUtil.getConnection();
		try {
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, ad.getPicture());
			pStatement.setString(2, ad.getSlogan());
			pStatement.setInt(3, ad.getState());
			pStatement.setDate(4, ad.getTime());
			pStatement.setInt(5, ad.getId());
			num = pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(con, pStatement, null);
		}
		return num;
	}
	public Advertisement loadAd(Integer id) {
		String sql = "select * from advertisement where id=?";
		PreparedStatement pStatement = null;
		Connection con = DBUtil.getConnection();
		ResultSet rs = null;
		Advertisement ad = null;
		try {
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, id.toString());
			rs = pStatement.executeQuery();
			if (rs.next() == false) {
				ad = new Advertisement();
				ad.setId(id);
			} else {
				ad = new Advertisement(rs.getString("shop_id"), rs.getString("picture"), rs.getString("slogan"),
						rs.getInt("state"), rs.getDate("time"));
				ad.setId(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(con, pStatement, rs);
		}
		return ad;
	}
}
