package homeWork28;

public class Calculator implements Impl {

	@Override
	public int add(int num1, int num2) {
		// TODO Auto-generated method stub
		System.out.println(num1+"+"+num2+"="+(num1+num2));
		return num1 + num2;
	}

	@Override
	public int sub(int num1, int num2) {
		// TODO Auto-generated method stub
		System.out.println(num1+"-"+num2+"="+(num1-num2));
		return num1 - num2;
	}

	@Override
	public int mul(int num1, int num2) {
		// TODO Auto-generated method stub
		System.out.println(num1+"*"+num2+"="+(num1*num2));
		
		return num1 * num2;
	}

	@Override
	public int div(int num1, int num2) {
		// TODO Auto-generated method stub
		System.out.println(num1+"/"+num2+"="+(num1/num2));
		return num1 / num2;
	}
	public void info(){
		System.out.println("hell0");
	}

}
