package hw3m17;

import java.util.Calendar;
import java.util.GregorianCalendar;

class LeftHand implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Calendar c = null;
		for (int i = 0; i < 4; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c = new GregorianCalendar();
			System.out.println(Thread.currentThread().getName() + "\t" + "A"
					+ "\t" + c.get(Calendar.SECOND) + "\t"
					+ c.get(Calendar.MILLISECOND));

		}
	}
}

class RightHand implements Runnable {

	@Override
	public void run() {
		Calendar c = null;
		// TODO Auto-generated method stub
		for (int i = 0; i < 4; i++) {
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c = new GregorianCalendar();
			System.out.println(Thread.currentThread().getName() + "\t" + "B"
					+ "\t" + c.get(Calendar.SECOND) + "\t"
					+ c.get(Calendar.MILLISECOND));

		}
	}

}

public class MyThread06 {

	public static void main(String[] args) {
		// ��ϰ1��4��������дA������дB��A˯500��B˯30.
		new Thread(new LeftHand(), "����дA").start();
		new Thread(new RightHand(), "����дB").start();
	}

}
