package hw3m7;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;



public class Test01 {

	public static void main(String[] args){
		Student s1 = new Student("张三", 20,56,"1m2");
		Student s2 = new Student("张三", 20,56,"1m2");

		Student s3 = new Student("Leo", 18,29,"2m3");
		Student s4 = new Student("Jak", 18,29,"5m2");
		Student s5 = new Student("Maggie", 19,78,"9m2");
		Student s6 = new Student("Rose", 20,78,"8m20");
		Student s7 = new Student("许宁", 20,36,"12m9");
		Student s8 = new Student("周迅", 20,36,"6m10");
		Student s9 = new Student("Tom", 20,78,"9m29");
		Student s10 = new Student("Tom", 20,55,"9m29");
		Set<Student> s = new TreeSet<Student>();
		
		s.add(s1);
		s.add(s2);
		s.add(s3);
		s.add(s4);
		s.add(s5);
		s.add(s6);
		s.add(s7);
		s.add(s8);
		s.add(s9);
		s.add(s10); 
	
		
		System.out.println(s.size());
		
		for(Iterator<Student> it = s.iterator();it.hasNext();)
			System.out.println(it.next());
	}
}
