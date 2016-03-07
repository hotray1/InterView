package cn.ot.Interview;
/**
 * 实践多线程
 * @author Administrator
 *
 */
public class Store {
	
	private final int MAX_SIZE ; // 仓库容量
	private int count; // 合计
	
	public Store(int n) {
		MAX_SIZE = n;
		count = 0;
	}
	
	public synchronized void add() {
		while(count >= MAX_SIZE) {
			System.out.println("仓库已满");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		count++;
		System.out.println(Thread.currentThread().getName() + "当前仓库存数 => " + count);
		this.notifyAll(); // 唤醒消费者线程
		
	}

	public synchronized void remove() {
		while(count <= 0) {
			System.out.println("仓库空了");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		count--;
		System.out.println(Thread.currentThread().getName() + "当前仓库存数 => " + count);
		this.notifyAll(); // 唤醒消费者线程
	}

	public static void main(String[] args) {
		Store s = new Store(5);
		Thread pro = new Producer(s);
		Thread con = new Consumer(s);
		pro.setName("Producer");
		con.setName("Consumer");
		pro.start();
		con.start();
	}
}

// 生产者线程
class  Producer extends Thread {
	public Store s;
	public Producer(Store s) {
		super();
		this.s = s;
	}
	@Override
	public void run() {
		while(true) {
			s.add();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

// 消费者线程
class Consumer extends Thread {
	private Store s;

	public Consumer(Store s) {
		this.s = s;
	}
	@Override
	public void run() {
		while(true) {
			s.remove();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
