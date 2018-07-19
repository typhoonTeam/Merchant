package typhoon.merchant.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;

public class ImgUtil {

	//图片转换成base64字符
    public static String imgUrl2String(String imgUrl) {
    	String result ="";
    	try {
    		FileInputStream stream = new FileInputStream(imgUrl);
    		byte[] bs=new byte[stream.available()];
    		stream.read(bs);
    		result= Base64.getEncoder().encodeToString(bs);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return result;
    }
    //图片转换成base64字符
    public static String img2String(InputStream stream) {
    	String result ="";
    	try {
    		byte[] bs=new byte[stream.available()];
    		stream.read(bs);
    		result= Base64.getEncoder().encodeToString(bs);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return result;
    }
    
    //base64转换成二进制数组
    public static byte[] string2Img(String img) {
    	byte[] bs=null;
    	try {
    		bs = Base64.getDecoder().decode(img);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		}
		return bs;
    }
    
}
