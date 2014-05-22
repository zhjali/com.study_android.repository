package hw3m14;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class MemeryRead {
	public static void main(String[] args) throws IOException {
		OutputStream out = new FileOutputStream(new File("E:\\Web.html"));
		InputStream in = new FileInputStream(new File("C:\\Web.html"));
		ByteArrayOutputStream aOut = new ByteArrayOutputStream();
		byte[] b = new byte[600];
		int len = 0;
		while((len = in.read(b))!= -1){
			aOut.write(b,0,1);
		}
		ByteArrayInputStream aIn = new ByteArrayInputStream(b);
		while((len = aIn.read(b))!= -1){
			out.write(b,0, len);
		}
		System.out.println("Success");
	}
}
