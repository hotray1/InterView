package cn.ot.Interview;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收器
 * @author Administrator
 *
 */
public class UDPReceiver {
	public static void main(String[] args) throws Exception {
		DatagramSocket ds = new DatagramSocket(8888);
		byte[] buff = new byte[5];
		DatagramPacket dp = new DatagramPacket(buff,5);
		ds.receive(dp);
		String str = new String(dp.getData());
		System.out.println(str);
		ds.close();
	}
}
