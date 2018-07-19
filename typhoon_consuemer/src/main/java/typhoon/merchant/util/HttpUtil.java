package typhoon.merchant.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
/*
 * add dunn 2018/7/13
 */
public class HttpUtil {
	public static String send(URL url,Map<String, String> map) throws IOException {
		// TODO Auto-generated method stub
		{
//
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();     
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");      
			connection.setUseCaches(false);  
			connection.setInstanceFollowRedirects(true);      
			connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			connection.connect();
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			
			int count = 0;
			for(Map.Entry<String, String> entry: map.entrySet())
			{
				String content=  entry.getKey()+ "="+entry.getValue();
				count++;
				if(count!=map.size()) {
					content+="&";
				}
				out.writeBytes(content);
			}
			
			out.flush();
			out.close();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
			String line;
			StringBuilder sb=new StringBuilder();
			while ((line = reader.readLine()) != null){
				sb.append(line);
			}
//			System.out.println(sb.toString());
			reader.close();
			connection.disconnect();
			return sb.toString();
		}
	}

}
