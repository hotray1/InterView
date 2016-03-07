package cn.ot.Interview;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的使用
 * @author Administrator
 *
 */

// 主程序
public class ThreadPoolTest {
	private static int produceTaskSleepTime = 2000;
	public static void main(String[] args) {
		// 线程池
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, 
				new ArrayBlockingQueue<Runnable>(3),
				new ThreadPoolExecutor.DiscardOldestPolicy()
				);
		String task ;
		int i = 0;
		while(true) {
			// 将线程加到线程池
			try {
				Thread.sleep(produceTaskSleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
			task = "加入线程 @ " + i;
			threadPoolExecutor.execute(new Threadshow(task));
			System.out.println(task);
		}

	}
}

// 线程对象
class Threadshow implements Runnable  {
	static int threadsleeptime = 2000;
	String task;
	
	Threadshow(String task) {
		this.task = task;
	}

	// 要跑的程序
	public void run() {
		try {
			Thread.sleep(threadsleeptime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("开启线程" + task);
	}
}



