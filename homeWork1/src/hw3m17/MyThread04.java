
package hw3m17;

	public class MyThread04 implements Runnable {

		private int i = 0;

		@Override
		public void run() {// ˼�����쳣ֻ�ܲ���
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
			Thread t1 = new Thread(new MyThread04(), "���߳�");
			t1.start();
			int i = 0;
			while (true) {
				System.out.println("...");
				try {
					// Thread.sleep(20);
					t1.sleep(20);// �˴�����˭˯�ˣ�
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\t\tmain...." + i++);
			}
		}
	}


