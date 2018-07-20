package typhoon.merchant.dao;

import typhoon.merchant.pojo.RegisterInfo;
import typhoon.merchant.pojo.User;

public interface RegisterInfoDao {
	public int addRegisterInfo(RegisterInfo RegisterInfo);

	public RegisterInfo findRegisterInfoByShopId(String shopId);
	public int addOrUpdateRegisterInfo(RegisterInfo registerInfo);
	public void deleteRegisterInfo(RegisterInfo registerInfo);

}
