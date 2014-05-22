package week3m15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class Translation {

	public static void read1 (String srcPath,String destPath)throws IOException{
		BufferedReader reader = new BufferedReader(
				new FileReader(new File(srcPath)));
		BufferedWriter writer = new BufferedWriter(
				new FileWriter(new File(destPath)));
		String i;
		while((i = reader.readLine()) != null){
			writer.write(i);
			System.out.println(i);
		}
	}
	
	public static void read2 (String srcPath,String destPath)throws IOException{
		InputStream in = new FileInputStream(
				new File(srcPath));
		OutputStream out = new FileOutputStream(
				new File(destPath));
		byte[] b = new byte[1024];
		int i = 0;
		while((i = in.read(b)) != -1){
			out.write(b, 0, i);
			System.out.println(new String(b,0,i));
		}
	}	
	
	public void read3(File f1,File f2,File f3,File f5){
		try {
			RandomAccessFile file = new RandomAccessFile(f1, "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
//		Translation.read1("C:\\Documents and Settings\\Administrator\\×ÀÃæ\\rfc2578.txt"
//				,"C:\\1.txt");
		Translation.read2("C:\\Documents and Settings\\Administrator\\×ÀÃæ\\rfc2578.txt"
				,"C:\\2.txt");
	}
}
