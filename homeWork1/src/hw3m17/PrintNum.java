package hw3m17;


public class PrintNum implements Runnable{
	private int times;
	
	

	public PrintNum(int times) {
		super();
		this.times = times;
	}

	public void run() {
		while (true) {
			for (int i = 0; i < times; i++) {
				System.out.println(Thread.currentThread().getName()
						+": "+i);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new PrintNum(10),"Thread A");
		Thread t2 = new Thread(new PrintNum(20),"Thread B");
		t1.start();
		t2.start();
	}
}
