package homeWork3m4;

public class ExceptionSample {
	public static void main(String[] args){
		int i = 1;
		int b = Integer.parseInt(args[0]);
		int result;
		try{
		result = i/b;
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("no parameter");
		}catch(ArithmeticException e){
			System.out.println("Arithmetic exception");
		}finally{
			System.out.println("finally you must do");
		}
	}

}
