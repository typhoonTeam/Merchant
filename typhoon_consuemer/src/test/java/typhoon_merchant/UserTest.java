package typhoon_merchant;

import org.junit.Before;
import org.junit.Test;

import typhoon.merchant.dao.UserDao;
import typhoon.merchant.dao.impl.UserDaoImpl;
import typhoon.merchant.pojo.User;

public class UserTest {
	UserDao userDao = null;

	@Before
	public void before() {
		userDao = new UserDaoImpl();
	}

	@Test
	public void addUser() {
		userDao.addUser(new User("123","123"));
	}
	@Test
	public void findUserByName() {
		userDao.findUserByUsername("qwh");
	}
}
