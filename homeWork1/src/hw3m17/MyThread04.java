
package hw3m17;

	public class MyThread04 implements Runnable {

		private int i = 0;

		@Override
		public void run() {// 思考：异常只能捕获
			while (true) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "\t" + i++);
			}
		}

		public static void main(String[] args) {
			Thread t1 = new Thread(new MyThread04(), "子线程");
			t1.start();
			int i = 0;
			while (true) {
				System.out.println("...");
				try {
					// Thread.sleep(20);
					t1.sleep(20);// 此处，是谁睡了？
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\t\tmain...." + i++);
			}
		}
	}


