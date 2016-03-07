package cn.ot.Interview;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 客户端
 * @author Administrator
 *
 */
public class TCPClient {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("localhost",8888); // 创建客户端端口
		OutputStream out = s.getOutputStream();  // 获得端口中的输出流 
		PrintWriter pw = new PrintWriter(out);	 // 输出对象
		pw.println("hello server , I am comming"); // 输出数据
		pw.close();
		s.close();
		
	}
}
