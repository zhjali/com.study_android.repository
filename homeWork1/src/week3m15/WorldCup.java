package week3m15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WorldCup {
	private static Map<String, String[]> map = 
						new HashMap<String,String[]>();

	public static Map<String,String[]> getMap(File file) throws IOException{
		BufferedReader reader = new BufferedReader(
				new FileReader(file));
		String string = null;
		String strKey = null;
		String[] strValue = null;
		while((string = reader.readLine()) != null){
			if(string.matches("\\d.*")){
				strKey = string.substring(0,string.indexOf('|'));
				strValue = string.substring(string.indexOf('|')+1)
						.split("\\|");
				map.put(strKey, strValue);
			}
		}
		return map;
	}
	
	public void showMap(){
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		System.out.println(set);
		while(it.hasNext()){
			String str = it.next();
			System.out.println(it.next()+": "
					+map.get(str)[0]+": "+map.get(str)[1]);
		}
	}
	
	public void judge(int year){
		String key = String.valueOf(year);
		String[] str = null;
		if((str = map.get(key)) != null){
			System.out.println("日期:"+key+" 举办国:"+
						str[0]+" 冠军国:"+str[1]);
		}else{
			System.out.println(key+"年没有举办世界杯");
		}
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		WorldCup wc = new WorldCup();
		WorldCup.getMap(new File("C:\\message.txt"));
		wc.judge(1982);
		wc.judge(1983);
		wc.judge(2000);
	}

}
