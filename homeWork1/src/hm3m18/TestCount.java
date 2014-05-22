package hm3m18;


public class TestCount extends Thread {
	private int count = 0;

	@Override
	public void run() {
		test1();
	}

	public synchronized void test1() {
		System.out.println("test1方法即将修改cont的值，改为1000");
		count = 1000;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("test1中count的值：" + count);
	}

	public synchronized void test2() {
		System.out.println("test2方法即将修改cont的值，改为3000");
		count = 3000;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("test2中count的值：" + count);
	}

	public static void main(String[] args) {
		TestCount tc = new TestCount();
		tc.start();// 启动线程
		tc.test2();// 对象调用方法。。
		// 练习1：理解同步方法
		// 练习2：修改以上代码。。
	}

}

