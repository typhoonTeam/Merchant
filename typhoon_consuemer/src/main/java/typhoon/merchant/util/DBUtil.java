package typhoon.merchant.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	public static Properties conf = new Properties();
	static {
		try {
			conf.load(new FileInputStream(getRealPath("dbconf.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String getRealPath(String filePath) {
		System.out.println("配置文件路径 ："+DBUtil.class.getResource("/" + filePath).toString().substring(6));
		return DBUtil.class.getResource("/" + filePath).toString().substring(6);
	}

	public static Connection getConnection() {
		String url = conf.getProperty("url");
		String username = conf.getProperty("username");
		String password = conf.getProperty("password");
		try {
			Class.forName(conf.getProperty("driverClass"));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void close(Connection con, Statement st, ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
				if (con != null)
					con.close();
				if (st != null)
					st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
