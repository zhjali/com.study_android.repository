package home24;

public class Student {
	String name;
	int age;
	static String address;// 属于类，
	static int count;
	

	Student() {
		count++;
		this.name = "无名"+count;
		this.age = 30;
	}

	Student(String name, int age, String address) {
		count++;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	Student(String name, int age) {
		count++;
		this.name = name;
		this.age = age;
	}

	public void printInfo() {
		System.out.println("name：" + name + "\tage:" + age + "\taddress："
				+ address);
	}
}

