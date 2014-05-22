package hm3m18;


public class TestCount extends Thread {
	private int count = 0;

	@Override
	public void run() {
		test1();
	}

	public synchronized void test1() {
		System.out.println("test1���������޸�cont��ֵ����Ϊ1000");
		count = 1000;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("test1��count��ֵ��" + count);
	}

	public synchronized void test2() {
		System.out.println("test2���������޸�cont��ֵ����Ϊ3000");
		count = 3000;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("test2��count��ֵ��" + count);
	}

	public static void main(String[] args) {
		TestCount tc = new TestCount();
		tc.start();// �����߳�
		tc.test2();// ������÷�������
		// ��ϰ1�����ͬ������
		// ��ϰ2���޸����ϴ��롣��
	}

}

