package work27;

public class Teacher extends Person{
	String course;
	
	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(!super.equals(obj))
			return false;
		if(getClass() != obj.getClass())
			return false;
		Teacher th = (Teacher) obj;
		if(course.equals(th.course))
			return true;
		return false;		
	}
	

	
	public Teacher() {

	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (!super.equals(obj))
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Teacher other = (Teacher) obj;
//		if (course == null) {
//			if (other.course != null)
//				return false;
//		} else if (!course.equals(other.course))
//			return false;
//		return true;
//	}



	public Teacher(String name, int age,String course) {
		super(name, age);
		this.course = course;
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		Person p1 = new Person("a",12);
		Person p2 = new Person("b",12);
		Person p3 = new Person("a",11);
		Person p4 = new Person("a",11);
		Teacher t1 = new Teacher("t",23,"shuxue");
		Teacher t2 = new Teacher("a",23,"yuwen");
		Teacher t3 = new Teacher("t",34,"shuxue");
		Teacher t4 = new Teacher("a",23,"shuxue");
		Teacher t5 = new Teacher("t",23,null);
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		System.out.println(p3.equals(p4));
		System.out.println(p2.equals(p3));
		System.out.println(t1.equals(a));
		System.out.println(t1.equals(t5));
	}

}
