package hm3m18;

import javax.annotation.processing.FilerException;

public class Feibonaqie implements Runnable{
	private int result;

	public int getResult(int mon) {
		if (mon == 1 || mon == 2) {
			return 1;
		} else {
			return getResult(mon-1)+getResult(mon-2);
		}
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Feibonaqie(int result) {
		super();
		this.result = result;
	}
	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName()
					+getResult(result));

	}
	public static void main(String[] args) {
		Thread t1 = new Thread(new Feibonaqie(5),"ThreadA");
		Thread t2 = new Thread(new Feibonaqie(8),"ThreadB");
		Thread t3 = new Thread(new Feibonaqie(12),"ThreadC");
		Thread t4 = new Thread(new Feibonaqie(11),"ThreadD");
		Thread t5 = new Thread(new Feibonaqie(6),"ThreadE");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

	
}
