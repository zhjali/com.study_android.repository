package home24;

public class TestStudent {
	public static void main(String[] args) {
		Student s1 = new Student("张三", 30, "广西");
		Student s2 = new Student("李四", 29);
		Student s3 = new Student("王五", 28);
		s1.printInfo();
		s2.printInfo();
		s3.printInfo();
		Student.address = "广东";
		System.out.println("修改后：。。。。。。");
		s1.printInfo();
		s2.printInfo();
		s3.printInfo();
		Student s4 = new Student();
		s4.printInfo();
		System.out.println(s4.name + "\t" + s4.address);
		// 练习1：利用static关键字，统计该类共创建了多少个对象
	}
}
