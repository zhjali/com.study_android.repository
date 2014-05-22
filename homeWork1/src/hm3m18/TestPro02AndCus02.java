package hm3m18;


class Bread {
	private int id;

	public Bread(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}

	@Override
	public String toString() {
		return "Bread [id=" + id + "]";
	}

}

class Box {
	private Bread[] breads = new Bread[8];
	private int index = 0;

	public Bread[] getBreads() {
		return breads;
	}

	public void setBreads(Bread[] breads) {
		this.breads = breads;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}

class Pro02 implements Runnable {
	private Box box;
	private int id = 1;

	public Pro02(Box box) {
		// TODO Auto-generated constructor stub
		this.box = box;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (box) {// p1
				while (box.getIndex() == box.getBreads().length) {// �������ˣ���������
					try {
						box.wait();// �����ߵȴ�
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Bread bread = new Bread(id++);
				box.getBreads()[box.getIndex()] = bread;// breads[index]=break;
				box.setIndex(box.getIndex() + 1);
				System.out.println(Thread.currentThread().getName()
						+ "\t���������������" + bread);
				// box.notify();// ����������
				box.notifyAll();// �������д��ڵȴ���������
				try {
					Thread.sleep((int) (Math.random() * 100));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class Cus02 implements Runnable {
	private Box box;

	public Cus02(Box box) {
		// TODO Auto-generated constructor stub
		this.box = box;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			synchronized (box) {
				while (box.getIndex() == 0) {
					try {
						box.wait();// �����ߵȴ�
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				box.setIndex(box.getIndex() - 1);
				Bread bread = box.getBreads()[box.getIndex()];
				System.out.println("\t\t" + Thread.currentThread().getName()
						+ "���ѵ������" + bread);
				// box.notify();// ��ʾ���Ѹղŵȴ����̣߳�������
				box.notifyAll();// �������еȴ���������
				try {
					Thread.sleep((int) (Math.random() * 100));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}

public class TestPro02AndCus02 {
	public static void main(String[] args) {
		Box box = new Box();
		Pro02 p1 = new Pro02(box);
		Cus02 c1 = new Cus02(box);
		Thread t1 = new Thread(p1, "���1");
		Thread t2 = new Thread(c1, "�Ի�1");
		Thread t3 = new Thread(p1, "���2");
		Thread t4 = new Thread(c1, "�Ի�2");
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}
}

