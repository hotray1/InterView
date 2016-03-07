package cn.ot.Interview;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP多线程
 * @author Administrator
 *
 */
public class TCPServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(8888);
		Socket s = null;
		while((s=ss.accept()) !=null) {
			Thread t = new MyThreadOfInterview(s);
		}
	}
}

class MyThreadOfInterview extends Thread{
	private Socket s;

	public MyThreadOfInterview(Socket s) {
		super();
		this.s = s;
	}
	@Override
	public void run() {
		try {
			InputStream in = s.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String str = br.readLine();
			System.out.println(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
