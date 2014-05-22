package hw3m17;

public class Paint extends Thread implements Runnable{
	private char ch;
	private int time;
	
	
	public Paint(char ch, int time) {
		super();
		this.ch = ch;
		this.time = time;
	}

	public void run() {
		while (true) {
			System.out.println(ch);
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Paint('A',5000),"Thread A");
		Thread t2 = new Thread(new Paint('B',300),"Thread B");
		t1.start();
		t2.start();
	}
}
