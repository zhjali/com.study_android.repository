package test;

import java.io.*;

public class SequenceTes {
	
	public static void main(String[] args){
		FileInputStream in1 = null,in2 = null;
		SequenceInputStream s = null;
		FileOutputStream out = null;
		try{
			in1 = new FileInputStream(new File("c:\\1.txt"));
			in2 = new FileInputStream(new File("c:\\2.txt"));
			s = new SequenceInputStream(in1,in2);
			out = new FileOutputStream(new File("c:\\12.txt"));
			
			int c;
			while((c = s.read())!=-1){
				out.write(c);
			}	
				in1.close();
				in2.close();
				s.close();
				out.close();
				System.out.println("ok...");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
