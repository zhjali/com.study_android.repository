package hw3m10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Mail {
	
	public Map<String,String> separat(String str){
		String[] str1 = str.split(",");
		String[] str2 = null;
		Map<String,String> map = new HashMap<String, String>();
		for(int i = 0; i<str1.length;i++){
			str2 = str1[i].split("@");
			map.put(str2[0], str2[1]);
		}
		return map;
	}
	
	public static void main(String[] args) {
		String string = "aa@sohu.com,bb@163.com,cc@sina.com";
		Mail mail = new Mail();
		Map<String, String> map;
		map = mail.separat(string);
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str + ":" + map.get(str));
		}
	}
}
