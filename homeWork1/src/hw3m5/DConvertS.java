package hw3m5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DConvertS {

	public static String getStringFormate(Date date ,String p){
		SimpleDateFormat sdf = new SimpleDateFormat(p);
		String str =  sdf.format(date);
		return str;
	}
	public static Date getDateFormate(String str,String p){
		SimpleDateFormat sdf = new SimpleDateFormat(p);
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
