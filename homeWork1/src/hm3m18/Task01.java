package hm3m18;

class ManTou {
	private int id;

	public ManTou(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}

	@Override
	public String toString() {
		return "ManTou [id=" + id + "]";
	}

}

class Basket {
	private ManTou[] manTous = new ManTou[8];
	private int index = 0;

	/**
	 * 生产馒头后存入
	 * 
	 * @param mt
	 */
	public synchronized void push(ManTou mt) {
		if (index == manTous.length) {
			try {
				this.wait();// t1,生产者等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		manTous[index] = mt;
		System.out.println("生产了馒头：" + mt);
		index++;// 1
		this.notify();// 唤醒消费者,存在空唤醒
	}

	/**
	 * 消费者吃馒头
	 */
	public synchronized void pop() {
		if (index == 0) {
			try {
				this.wait();// 消费者等待。。。
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		index--;// 0
		ManTou mt = manTous[index];
		System.out.println("\t\t消费了馒头：" + mt);
		this.notify();// 锁的对象唤醒刚才处于等待状态的线程。。存在空唤醒。。
	}

}

// 生产者：负责生产馒头
class Pro01 implements Runnable {
	private int id = 0;
	private Basket basket;

	Pro01(Basket basket) {
		this.basket = basket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			ManTou mt = new ManTou(id++);
			basket.push(mt);
			try {
				Thread.sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

// 消费者：负责吃
class Cus01 implements Runnable {
	private Basket basket;

	Cus01(Basket basket) {
		this.basket = basket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			basket.pop();
			try {
				Thread.sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

public class Task01 {

	public static void main(String[] args) {
		Basket basket = new Basket();
		Pro01 p1 = new Pro01(basket);
		Cus01 c1 = new Cus01(basket);
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(c1);
		t1.start();
		t2.start();
	}

}
