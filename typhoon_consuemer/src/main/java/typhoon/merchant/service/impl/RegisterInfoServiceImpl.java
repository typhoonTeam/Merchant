package typhoon.merchant.service.impl;

import typhoon.merchant.dao.RegisterInfoDao;
import typhoon.merchant.dao.impl.RegisterInfoDaoImpl;
import typhoon.merchant.dao.impl.ResturantDaoImpl;
import typhoon.merchant.pojo.RegisterInfo;
import typhoon.merchant.service.RegisterInfoService;

public class RegisterInfoServiceImpl implements RegisterInfoService {

	private static RegisterInfoServiceImpl instance;
	RegisterInfoDao registerInfoDao;

	private RegisterInfoServiceImpl() {
		initData();
	}

	public static RegisterInfoServiceImpl getInstance() {
		if (instance == null) {
			synchronized (RegisterInfoServiceImpl.class) {
				if (instance == null) {
					instance = new RegisterInfoServiceImpl();
				}
			}
		}
		return instance;
	}

	public void initData() {
		registerInfoDao = new RegisterInfoDaoImpl();
	}

	public void addRegisterInfo(RegisterInfo registerInfo) {
		registerInfoDao.addRegisterInfo(registerInfo);
	}

	public RegisterInfo findRegisterInfoByShopId(String shopId) {
		return registerInfoDao.findRegisterInfoByShopId(shopId);
	}
}
