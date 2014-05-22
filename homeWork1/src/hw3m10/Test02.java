package hw3m10;

import home24.Student;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p1 = new Person("z", "m", 12, 60);
		Person p2 = new Person("z", "m", 12, 80);
		Person p3 = new Person("f", "m", 79, 90);
		Person p4 = new Person("d", "w", 45, 20);
		Person p5 = new Person("e", "m", 19, 20);
		Person p6 = new Person("a", "w", 23, 50);
		Person p7 = new Person("k", "m", 30, 73);
		
		Map<Person, String> map = new HashMap<Person, String>();
		map.put(p1, p1.getRange());
		map.put(p2, p2.getRange());
		map.put(p3, p3.getRange());
		map.put(p4, p4.getRange());
		map.put(p5, p5.getRange());
		map.put(p6, p6.getRange());
		map.put(p7, p7.getRange());
		
//		Iterator<Person> it = map.keySet().iterator();
//		while(it.hasNext()){
//			Person person = it.next();
//			System.out.println(map.get(person)+": "+person);
//		}
		
		Set<Map.Entry<Person, String>> set = map.entrySet();
		Iterator<Map.Entry<Person, String>> it = set.iterator();
		int mount = 1;
//		while(it.hasNext()){
//			Map.Entry<Person, String> entry = it.next();
//			System.out.println(mount++ +""+ entry.getKey() + ": " 
//					+ entry.getValue());
//		}
		
		for (Entry<Person, String> entry : set) {
			System.out.println(mount++ +""+ entry.getKey() + ": " 
					+ entry.getValue());
		}
//		for(;it.hasNext();){
//			Map.Entry<Person, String> entry = it.next();
//			System.out.println(mount++ +""+ entry.getKey() + ": " 
//					+ entry.getValue());
//	
//		}
	}
}
