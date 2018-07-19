package typhoon.merchant.dao;

import typhoon.merchant.pojo.User;

public interface UserDao {
	public int addUser(User user);

	public User findUserByUsername(String name);

	public int updateUser(User user);
}
