package cn.ot.Interview;

import javax.management.RuntimeErrorException;

class Demo {

	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize方法垃圾回收机制开始 => 线程名是：" + Thread.currentThread().getName());
	}
	
}

public class GC {

	public static void main(String[] args) {
		Demo demo = new Demo();
		new Demo();
		System.gc();
		throw new RuntimeException();
	}

}
