package hw3m17;

public class MultiThread extends Thread implements Runnable{
	private int time;
	
	
		public MultiThread(int time) {
		super();
		this.time = time;
	}
		public void run(){
			int i = 0;
			while(i < 10){
			try {

				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				System.out.println(Thread.currentThread()+"____>"+i++);
			}
		}
		public static void main(String[] args) {
			Thread t1 = new Thread(new MultiThread(1000), "线程A");
			Thread t2 = new Thread(new MultiThread(2000), "线程B");
			Thread t3 = new Thread(new MultiThread(3000), "线程C");
			t1.start();
			t2.start();
			t3.start();
			
		}
}
