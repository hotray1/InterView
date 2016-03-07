package cn.ot.Interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 聊天程序
 * @author Administrator
 *
 */
public class Chat {
	public static void main(String[] args) {
		// args[0] 表示用户输入的第一个参数 ，arg[0] 表示第二个参数
		new ReceiveThread(Integer.parseInt(args[0])).start();
		new SendThread(Integer.parseInt(args[1]), Integer.parseInt(args[2])).start();
	}
}

// 接收程序线程
class ReceiveThread extends Thread{
	private DatagramSocket ds;		// 创建数据报包的端口
	private int receivePort;		// 接收端口
	public ReceiveThread(int receivePort) {		// 构造函数
		try {
			this.ds = new DatagramSocket(receivePort); // 
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		byte[] buf = new byte[1024];	//创建字节数组
		DatagramPacket dp =new DatagramPacket(buf, 1024);	// 创建数据报包
		while(true) {
			try {
				ds.receive(dp);		//接收数据报包
				String str = new String(dp.getData(),0,dp.getLength());	  // 通过 String 将字节数据转成字符串数据
				System.out.println(str);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ds.close();
			}
		}
	}
	
}

// 发送程序线程
class SendThread extends Thread{
	private DatagramSocket ds;
	private int sendPort; 					
	public SendThread(int port,int sendPort) {
		super();
		this.sendPort = sendPort;
		try {
			this.ds = new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try {
			while((str = br.readLine()) != null) {
				DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), InetAddress.getByName("localhost"), sendPort);
				ds.send(dp);
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ds.close();
		}
		super.run();
	}
}
