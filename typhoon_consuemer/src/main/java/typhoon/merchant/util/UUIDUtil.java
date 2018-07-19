package typhoon.merchant.util;

import java.util.UUID;

/**
 * 
 * @author QIUHU
 *
 */
public class UUIDUtil {
public static String uuid32(){
	return UUID.randomUUID().toString().replace("-", "");
}
}
