package cn.ot.Interview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
/**
 * 101 集 通过网络编程API来访问一个HTTP服务器WEB服务器，并返回页面的HTML源码
 * @author Administrator
 *
 */
public class URLs {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.sina.com.cn"); 
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.connect();
		Map<String,List<String>> headers = conn.getHeaderFields();
		for (String key : headers.keySet()) {
			System.out.println(headers.get(key));
			
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		while((br.readLine())!= null) {
			System.out.println(br.readLine());
		}
		br.close();
	}
}
