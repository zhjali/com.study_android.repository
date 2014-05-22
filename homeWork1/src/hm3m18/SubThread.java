package hm3m18;

public class SubThread extends Thread{
	public static Integer count = 100;
	public static Object object;
	
	
	
	public SubThread() {
		super();
		this.object = getObject();
	}

	private Object getObject() {
		if(object == null){
			object = new Object();
		}
		return object;
	}

	@Override
	public void run() {
		boolean flag = true;
		while (flag) {
			synchronized (object) {
				if (count > 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()
							+ "------->" + count--);
				} else {
					flag = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		SubThread sThread1 = new SubThread();
		SubThread sThread2 = new SubThread();
		SubThread sThread4 = new SubThread();
		SubThread sThread3 = new SubThread();

		sThread1.start();
		sThread2.start();
		sThread3.start();
		sThread4.start();
	}
}
