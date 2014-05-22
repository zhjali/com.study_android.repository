package homeWork28;

public abstract class Person {
	String name;
	int age;
	
	public  Person(){
		System.out.println("hello");
	}
	
	public abstract void eat();

	public abstract void goWC();
}
