package cn.ot.Interview;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Objectin {
	public static void main(String[] args) throws Exception {
		new Thread(new MyThread()).start(); // 开启线程
		
	}
	
}
// 自定义线程
class MyThread implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread()); // 显示当前线程名
	}
	
}