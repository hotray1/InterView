package cn.ot.Interview;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP/IP的编程模型是服务器和客户端的开发模式，API 在Java.net中
 * 服务器端
 * @author Administrator
 *
 */
public class TcpServiceTest {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(8888); // 创建端口
		Socket scoket = null;
		while((scoket = ss.accept()) != null) {
			InputStream in = scoket.getInputStream(); // 获得输入的数据
			BufferedReader br = new BufferedReader(new InputStreamReader(in) );
			System.out.println(br.readLine()); // 输出一行
			
		}
		scoket.close();
		ss.close();
	}
}
