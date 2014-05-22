package hw3m5;

public class ExceptionT {
	int a = 100;
	int b = 0;
	public void expcett() throws ArithmeticException  {
		System.out.println(a/b);
	}
	
	
	public static void main(String[] args) {
		ExceptionT e = new ExceptionT();
		
		e.expcett();
	}

}
