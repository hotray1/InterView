package cn.ot.Interview;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 第 85 集
 * 线程池的管理：业务逻辑和线程代码之间的分离
 * ArrayBlockingQueue<E>:一个由数组支持的有界阻塞队列。
 * 类 ThreadPoolExecutor.DiscardOldestPolicy:用于被拒绝任务的处理程序，它放弃最旧的未处理请求，然后重试 execute；如果执行程序已关闭，则会丢弃该任务。 
 * @author Administrator
 *
 */
// 第一个类
public class ThreadPool {
	
	private static int produceTaskSleepTime = 2000; // 生产任务的休息时间
	
	public static void main(String[] args) {
		// 构造一个线程池
		ThreadPoolExecutor producerPool = 
				new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, // corePoolSize 和 maximumPoolSize 相同，则创建了固定大小的线程池。0保持活动时间,TimeUnit.SECONDS设置时间单位秒级
						new ArrayBlockingQueue<Runnable>(3),      // 执行前用于保持任务的队列。有界队列（如 ArrayBlockingQueue）有助于防止资源耗尽
						new ThreadPoolExecutor.DiscardOldestPolicy()); // 由于超出线程范围和队列容量而使执行被阻塞时所使用的处理程序
		// 每隔produceTaskSleepTime 的时间向线程池派送一个任务
		int i = 1;
		while(true) {
			try {
				Thread.sleep(produceTaskSleepTime);
				String task = "task@" + i;
				System.out.println("放入线程 " + task);
				// 用 execute 方法启动一个线程
				producerPool.execute(new ThreadPoolTask(task));
				i++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
// 第二个类
// 线程类
class ThreadPoolTask implements Runnable {
	private static int consumeTaskSleepTime = 2000; // 时间间隙
	private String threadPoolTaskData; 				// 存储人物名的变量
	ThreadPoolTask(String tasks) {					// 构造方法
		this.threadPoolTaskData = tasks;
	}
	// 每个任务的执行过程，现在是什么都没做，除了 print 和 sleep
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("开启线程 .." + threadPoolTaskData);
		try {
			Thread.sleep(consumeTaskSleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadPoolTaskData = null;
	}
}