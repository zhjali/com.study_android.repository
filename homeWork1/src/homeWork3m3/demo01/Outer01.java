package homeWork3m3.demo01;

public class Outer01 {// �ⲿ��

	/**
	 * �ⲿ�������
	 */
	private int i = 6;
	private static String hello = "hello";

	/**
	 * �ⲿ��ķ���
	 */
	public void fun() {
		Inner01 i1 = new Inner01();
		i1.test();
	}

	class Inner01 {// �ڲ���
		private int i = 10;

		public void test() {
			System.out.println(this.i);// �ڲ��������
			System.out.println(Outer01.this.i);// �ⲿ�������
		}
	}

}

class Inner01 {

}
