package homeWork3m3.demo01;

public class Outer02 {
	private static String hello1 = "hello";
	private static String hello2 = "statichello";
	private String hello3 = "statichello1";

	public static void fun() {
		System.out.println("fun");
	}
	
	public static void fun1() {
		System.out.println("staticfun1");
	}
	
	static class Inner02{
		String helloin1 = hello1;
		String helloin2 = hello2;
//		String helloin3 = hello3;
		
		
		public void info(){
			System.out.println(hello2);
			System.out.println(hello1);
			fun();
			fun1();
			
			System.out.println(hello1);
			System.out.println(hello2);
		}
		
	}
}
