package hw3m17;

public class TaskInte implements Runnable{
	private int i = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(i++ <100){
			System.out.println(Thread.currentThread().getName()
					+"_____>"+i);
		}
	}
	
	public static void main(String[] args) {
		TaskInte tInte = new TaskInte();
		Thread thread = new Thread(tInte);
		Thread thread2 = new Thread(tInte);
		Thread thread3 = new Thread(tInte);
		thread.start();
	}

}
