package hw3m13;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TaskBuffer {
	public static void main(String[] args) throws IOException, ParseException {
		File file = new File("C:\\1.txt");
		BufferedReader bf = new BufferedReader(
				new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(
				new FileWriter(file));
		String string2 = "";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		bw.write(dateFormat.format(new Date()));
		bw.newLine();
		dateFormat = new SimpleDateFormat("H:m:s");
		while(!string2.equals("over")){
			bw.write(dateFormat.format(new Date()));
			bw.newLine();
			string2 = bf.readLine();
			bw.write(string2);
			bw.newLine();
			bw.flush();
		}
		bw.close();
		
	}
}
