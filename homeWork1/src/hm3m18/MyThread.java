package hm3m18;

class Test01 {
	public static Integer count = 0;
	private static Test01 test = new Test01();
	
	public static Test01 getTest() {
		return test;
	}
	
	private Test01(){
		
	}
	public void add(String name) {
		synchronized (this) {
		count++;// t1,count:1
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + "\t,你是第" + count + "线程。。");
		
		}
	}
}

public class MyThread implements Runnable {
//	private Test01 test01 = new Test01();

	@Override
	public void run() {
//		test01.add(Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		MyThread mt = new MyThread();
		Thread t1 = new Thread(mt, "线程1");
		Thread t2 = new Thread(mt, "线程2");
		t1.start();
		t2.start();

	}

}
