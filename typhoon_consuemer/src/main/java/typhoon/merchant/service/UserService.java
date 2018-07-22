package typhoon.merchant.service;

import typhoon.merchant.pojo.RegisterInfo;
import typhoon.merchant.pojo.User;

public interface UserService {
	public int checkUserLogin(String username ,String password) ;
	public User findUser(String username ) ;
	public int addUser(User user);
	public int receiveCheckStatus(String shop_id);
	public int sendRegisterInfoToAdmin(RegisterInfo info);
	public int updatePassword(User user);
}
