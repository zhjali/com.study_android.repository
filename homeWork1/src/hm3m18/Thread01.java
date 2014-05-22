package hm3m18;

class Single2 {// ¿¡∫∫ Ω
	private static Single2 s2;
	private static String string = "";

	private Single2() {

	}

	public static Single2 getInstance2() {
		synchronized (Single2.class) {
			if (s2 == null) {// t1,t2,t3
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				s2 = new Single2();
			}
		}
		return s2;
	}
}

public class Thread01 implements Runnable {
	@Override
	public void run() {
		System.out.println(Single2.getInstance2());
		System.out.println(Single2.getInstance2());
		System.out.println(Single2.getInstance2());
		System.out.println(Single2.getInstance2());
	}

	public static void main(String[] args) {
		// Single2 s1 = Single2.getInstance2();
		// Single2 s2 = Single2.getInstance2();
		// Single2 s3 = Single2.getInstance2();
		// Single2 s4 = Single2.getInstance2();
		// System.out.println(s1);
		// System.out.println(s2);
		// System.out.println(s3);
		// System.out.println(s4);
		Thread01 ts = new Thread01();
		Thread t1 = new Thread(ts, "1");
		Thread t2 = new Thread(ts, "2");
		Thread t3 = new Thread(ts, "3");
		Thread t4 = new Thread(ts, "4");
		Thread t5 = new Thread(ts, "5");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

}
