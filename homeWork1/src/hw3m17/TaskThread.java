package hw3m17;

public class TaskThread extends Thread implements Runnable{

	public void run(){
		for(int i = 0; i < 26; i++){
			System.out.println((char)(i + 'a'));
		}
	}
	
	public static void main(String[] args) {
		TaskThread tt = new TaskThread();
		tt.start();
		for(int a = 0; a<=300; a++)
			System.out.println(a);
	}
}
