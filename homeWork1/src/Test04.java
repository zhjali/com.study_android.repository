
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
		A a = new A() {// �����ڲ���Ŀ�ʼ
			public void test() {
				System.out.println("helloworld......");
			}

			@Override
			public void fun() {
				// TODO Auto-generated method stub
				System.out.println("fdfdfdfdfd");
			}
		};// �����ڲ���Ľ���
		a.test();
		a.fun();
		// ��ϰ1���Գ�����Ϊ��������һ�����󷽷��������ó�����������ڲ�����÷�����
	}
}
