package hw3m10;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Scanner;

public class TestProperty {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		File file = new File("C:\\new.xml");
		Properties property = new Properties();
		property.put("name", "zhjali");
		property.put("Tel", "123344");
		property.put("Address", "xioaxikou");
		InputStream in = new FileInputStream(file);
		OutputStream out = new FileOutputStream(file);
//		property.store(out, "This is the first try");
		property.storeToXML(out, "hello");
		out.close();
		in.close();
		

	}

}
