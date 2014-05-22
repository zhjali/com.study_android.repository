

public class Outer03 {// 外部类
	private int i = 8;

	public void fun(final int k) {// 外部类的方法
		final int j = 9;
		class Inner03 {// 局部内部类
			private int i = 10;

			public void test() {
				// 线程：
				System.out.println(this.i);
				System.out.println(Outer03.this.i);
				System.out.println(j);
				System.out.println(k);
			}
		}
		new Inner03().test();
	}
}
