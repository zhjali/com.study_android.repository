package home24;

public class TestStudent {
	public static void main(String[] args) {
		Student s1 = new Student("����", 30, "����");
		Student s2 = new Student("����", 29);
		Student s3 = new Student("����", 28);
		s1.printInfo();
		s2.printInfo();
		s3.printInfo();
		Student.address = "�㶫";
		System.out.println("�޸ĺ󣺡�����������");
		s1.printInfo();
		s2.printInfo();
		s3.printInfo();
		Student s4 = new Student();
		s4.printInfo();
		System.out.println(s4.name + "\t" + s4.address);
		// ��ϰ1������static�ؼ��֣�ͳ�Ƹ��๲�����˶��ٸ�����
	}
}
