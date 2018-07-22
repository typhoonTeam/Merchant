package typhoon.merchant.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import typhoon.merchant.dao.UserDao;
import typhoon.merchant.dao.impl.ResturantDaoImpl;
import typhoon.merchant.dao.impl.UserDaoImpl;
import typhoon.merchant.pojo.RegisterInfo;
import typhoon.merchant.pojo.User;
import typhoon.merchant.service.UserService;
import typhoon.merchant.util.HttpUtil;
import typhoon.merchant.util.SendMsgWithJMS;

public class UserServiceImpl implements UserService {
	UserDao userDao;
	HttpUtil httpUtil;

	private static UserServiceImpl instance;
	private ResturantDaoImpl impl;

	private UserServiceImpl() {
		initData();
	}

	public static UserServiceImpl getInstance() {
		if (instance == null) {
			synchronized (UserServiceImpl.class) {
				if (instance == null) {
					instance = new UserServiceImpl();
				}
			}
		}
		return instance;
	}

	public void initData() {
		userDao = new UserDaoImpl();
		httpUtil = new HttpUtil();
	}

	public int sendRegisterInfoToAdmin(RegisterInfo info) {
		SendMsgWithJMS.send(info, "AMCQ2");
		return 0;
	}

	public int checkUserLogin(String username, String password) {
		User user = userDao.findUserByUsername(username);
		if (user == null) {
			System.out.println("this user can not be found!");
			return 0;
		} else if (user.getPassword().equals(password)) {
			System.out.println("å¯†ç �æ­£ç¡®ï¼�");
			return 1;
		} else {
			System.out.println("å¯†ç �é”™è¯¯ï¼�");
			return -1;
		}
	}

	public int addUser(User user) {
		if (findUser(user.getUsername()) != null) {
			System.out.println("è¯¥ç”¨æˆ·å��å·²è¢«æ³¨å†Œ");
			return 0;
		} else {
			userDao.addUser(user);
			return 1;
		}
	}

	public int receiveCheckStatus(String shop_id) {
		System.out.println(shop_id);
		// è¿”å›žçš„intç±»åž‹å¯¹åº”çš„ç»“æžœ
		// 0 :
		// 1 :
		// 2 :
		// 3 :
		// shop_id = "{shop_id:"+ shop_id + "}";
		Map<String, String> map = new HashMap<String, String>();
		map.put("queryStatus", shop_id);
		String receive = null;
		try {
			receive = httpUtil.send(new URL("http://10.222.29.189:8081/team_typhoon_admin/StatusCheck"), map);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("receive :" + receive);
		if (receive == null || receive.length() == 0)
			return 2;
		else {
			return Integer.parseInt(receive);
		}
	}

	public User findUser(String username) {
		User user = userDao.findUserByUsername(username);
		return user;
	}

	@Override
	public int updatePassword(User user) {
		return userDao.updatePassword(user);
	}
}
