

public class Outer03 {// �ⲿ��
	private int i = 8;

	public void fun(final int k) {// �ⲿ��ķ���
		final int j = 9;
		class Inner03 {// �ֲ��ڲ���
			private int i = 10;

			public void test() {
				// �̣߳�
				System.out.println(this.i);
				System.out.println(Outer03.this.i);
				System.out.println(j);
				System.out.println(k);
			}
		}
		new Inner03().test();
	}
}
