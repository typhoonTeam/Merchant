package typhoon.merchant.service.impl;

import typhoon.merchant.dao.impl.ResturantDaoImpl;
import typhoon.merchant.pojo.Resturant;
import typhoon.merchant.service.ResturantService;
/**
 * 
 * @author GAOJO2
 *
 */
public class ResturantServiceImpl implements ResturantService{
	private static ResturantServiceImpl instance;
	private ResturantDaoImpl impl;
	
    private ResturantServiceImpl(){
        initData();
    }
    public static ResturantServiceImpl getInstance(){
        if(instance==null){
            synchronized (ResturantServiceImpl.class){
                if(instance==null){
                    instance=new ResturantServiceImpl();
                }
            }
        }
        return instance;
    }
    
    public void initData() {
    	impl = new ResturantDaoImpl(); 
    }
    
   public int addDefaultResturant(String shopId) {
    	return impl.addDefaultResturant(shopId);
    }
    public Resturant findResturant(String shopId) {
    	Resturant res = impl.findResturant(shopId);
    	if(res == null) {
    		impl.addDefaultResturant(shopId);
    		res = impl.findResturant(shopId);
    	}
    	return res;
    }
    public int updateResturant(Resturant resturant) {
    	return impl.updateResturant(resturant);
    }
}
