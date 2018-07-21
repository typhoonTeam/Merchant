package typhoon.merchant.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Dunn 将json数据输出到浏览器
 */

public class JsonOutUtil {
	private static JsonParse json = new JsonParseByJackson();

	public static void outJson( HttpServletResponse response, Object object) {
		response.setContentType("application/json;charset=UTF-8");
		// 禁用缓存，确保网页信息是最新数据
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", -10);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String jsonStr = json.parseObjectToJson(object);
			System.out.println(jsonStr);
			out.print(jsonStr);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
}
