package cn.ot.Interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 服务器端
 * @author Administrator
 *
 */
public class TCPThread {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(8888);
		Socket s = null;
		while((s = ss.accept()) != null) {
			Thread t = new MyThreadOfTCP(s);
			t.start();
		}
		ss.close();
	}	
}

class MyThreadOfTCP extends Thread {
	private Socket s = null;
	public MyThreadOfTCP(Socket s) {
		super();
		this.s = s;
	}
	@Override
	public void run() {
		try {
			InputStream is = s.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String str = br.readLine();
			System.out.println("收到" + str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(s!=null) {
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
			
}