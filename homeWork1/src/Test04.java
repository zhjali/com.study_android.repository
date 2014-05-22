
interface A {
	public void test();

	public void fun();
}

//
// class B implements A {
//
// @Override
// public void test() {
// System.out.println("helloworld");
// }
//
// }

public class Test04 {

	public static void main(String[] args) {
		// A a = new B();
		// a.test();
		// new B().test();
		A a = new A() {// 匿名内部类的开始
			public void test() {
				System.out.println("helloworld......");
			}

			@Override
			public void fun() {
				// TODO Auto-generated method stub
				System.out.println("fdfdfdfdfd");
			}
		};// 匿名内部类的结束
		a.test();
		a.fun();
		// 练习1：以抽象类为例，中有一个抽象方法，创建该抽象类的匿名内部类调用方法。
	}
}
