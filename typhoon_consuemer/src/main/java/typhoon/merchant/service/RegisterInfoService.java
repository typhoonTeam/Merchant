package typhoon.merchant.service;

import typhoon.merchant.pojo.RegisterInfo;

public interface RegisterInfoService {
	public void addRegisterInfo(RegisterInfo registerInfo);

	public RegisterInfo findRegisterInfoByShopId(String shopId);
}
