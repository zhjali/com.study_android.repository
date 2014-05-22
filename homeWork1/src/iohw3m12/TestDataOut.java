package iohw3m12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestDataOut {
	public void read(File file) throws IOException{
		InputStream in = new FileInputStream(file);
		byte[] b = new byte[1024];
		int i = in.read(b);
		while(i != -1){
			System.out.println(new String(b,0,i));
			i = in.read(b);
		}
		in.close();
	}

	public static void main(String[] args) throws IOException {
		TestDataOut testDataOut = new TestDataOut();
		String string = "hello world";
		byte[] b = {49,3};
		File file = new File("C:\\new.txt");
		OutputStream out = new FileOutputStream(file);
	
		out.write(b);
		for(int i = 0; i<string.length(); i++)
			out.write(string.charAt(i));
		
		out.close();
		testDataOut.read(file);
	}
}
