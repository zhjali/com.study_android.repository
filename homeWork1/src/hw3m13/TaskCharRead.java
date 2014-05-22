package hw3m13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class TaskCharRead {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\workspace\\homeWork1\\src\\hw3m13\\TaskCharRead.java");
		Reader reader = new FileReader(file);
		char[] ch = new char[1024];
		int len;
		while((len =  reader.read(ch)) != -1){
			System.out.println(new String(ch));
		};
		reader.close();
		String str = "abcdefghijklmnopqrstuvwxyz";
		File file1 = new File("C:\\1.txt");
		File file2 = new File("C:\\2.txt");
		OutputStream out = new FileOutputStream(file1);
		Writer writer = new FileWriter(file2);
		out.write(str.getBytes());		
		writer.write(str.toCharArray());
		char[] ch3 = new char[Character.MAX_VALUE+1];
		for(int i = 0;i<=(int)Character.MAX_VALUE;i++){
			ch3[i] = (char)i;
		}
		writer.write(ch3);
		writer.flush();
		out.close();
		writer.close();
		
	}

}
