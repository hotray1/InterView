package cn.ot.Interview;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 开发UDP的编程模型？
 * 发送端
 * @author Administrator
 *
 */
public class UDPSend {
	public static void main(String[] args) throws Exception {
		DatagramSocket ds = new DatagramSocket(9999); // 创建数据报端口
		String str = "send message......";
		// 创建数据包
		DatagramPacket dp = new DatagramPacket(str.getBytes(), 0, str.length(), InetAddress.getByName("localhost"), 8888);
		// 发送
		ds.send(dp);
		ds.close();
	}
}
