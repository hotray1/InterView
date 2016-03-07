package cn.ot.Interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 用TCP来创建WEB服务器
 * 服务器端
 * @author Administrator
 *
 */
public class TCPWeb {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(80);
		Socket s = null;
		while((s = ss.accept()) != null) {
			Thread t = new MyThreadOfWEB(s);
			t.start();
		}
		ss.close();
	}	
}

class MyThreadOfWEB extends Thread {
	private Socket s = null;
	public MyThreadOfWEB(Socket s) {
		super();
		this.s = s;
	}
	@Override
	public void run() {
		try {
			
			PrintWriter pw = new PrintWriter(s.getOutputStream());
			pw.println("<html>");
			pw.println("<body>");
			pw.println("<h1>这是我的WEB服务器</h1>");
			pw.println("</body>");
			pw.println("</html>");
			pw.flush();
			
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