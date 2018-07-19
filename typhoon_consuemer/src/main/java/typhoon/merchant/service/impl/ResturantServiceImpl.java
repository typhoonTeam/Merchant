package typhoon.merchant.service.impl;

import typhoon.merchant.dao.ResturantDao;
import typhoon.merchant.dao.impl.ResturantDaoImpl;
import typhoon.merchant.service.ResturantService;

public class ResturantServiceImpl implements ResturantService {

	private static ResturantServiceImpl instance;
	private ResturantDaoImpl impl;

	private ResturantServiceImpl() {
		initData();
	}

	public static ResturantServiceImpl getInstance() {
		if (instance == null) {
			synchronized (ResturantServiceImpl.class) {
				if (instance == null) {
					instance = new ResturantServiceImpl();
				}
			}
		}
		return instance;
	}

	public void initData() {
		impl = new ResturantDaoImpl();
	}

	public void addResturant(String shopId) {
		impl.addResturant(shopId);
	}

	public Object findResturant(String shopId) {
		// TODO Auto-generated method stub
		return null;
	}
}
