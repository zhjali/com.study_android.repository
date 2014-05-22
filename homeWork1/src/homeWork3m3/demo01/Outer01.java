package homeWork3m3.demo01;

public class Outer01 {// 外部类

	/**
	 * 外部类的属性
	 */
	private int i = 6;
	private static String hello = "hello";

	/**
	 * 外部类的方法
	 */
	public void fun() {
		Inner01 i1 = new Inner01();
		i1.test();
	}

	class Inner01 {// 内部类
		private int i = 10;

		public void test() {
			System.out.println(this.i);// 内部类的属性
			System.out.println(Outer01.this.i);// 外部类的属性
		}
	}

}

class Inner01 {

}
