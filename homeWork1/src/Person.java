public class Person {
	int age;
	String name;
	String sex;
	String address;

	public Person(){
	}
	public Person(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public boolean eat(String food) {
		System.out.println("½ñÌì³Ô" + food);
		return true;
	}

	public void sleep() {
		System.out.println("sleep ....");
	}

	public void getWater() {
		System.out.println(name + "get some water ....");
	}

	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person();
		p2.toString();
		p1.name = "star";
		p1.age = 18;
		p1.sex = "Man";
		p2.name = "superMan";
		p1.sleep();
		p1.getWater();
		p2.sleep();
		p2.getWater();

	}
}
