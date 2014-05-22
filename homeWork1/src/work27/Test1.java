package work27;

public class Test1 {
	
	public char method(A a){
		char category;
		if( a instanceof B){
			B b = (B)a;
			b.test3();
			return 'B';
		}
		if(a instanceof C){
			C c = (C)a;
			c.test4();
			return 'C';
		}
		a.test1();
		return 'A';
	}
	
	public static void main(String [] args){
			A a = new A();
			B b = new B();
			C c = new C();
			Test1 t = new Test1();
			t.method(a);
			t.method(b);
			t.method(c);
			
	}
}
