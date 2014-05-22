package hw3m10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapPractice {
	public static void main(String[] args) {
		String name;
		String age;
		String tel;
		String sex;
		Map<String,String> map = new HashMap<String, String>();
		map.put("name", "zhaojialiang");
		map.put("age", "12");
		map.put("tel", "12322322");
		map.put("sex", "male");
		System.out.println(map.containsKey("sex"));
		Set<String> set = new HashSet<String>();
		set = map.keySet();
		Map<String,String> m = new HashMap<String, String>();
		map.putAll(m);
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			String key = it.next();
			System.out.println(key + ":"+map.get(key));
		}
		map.clear();
		System.out.println(map.containsKey("sex"));
		
		
	}
}
