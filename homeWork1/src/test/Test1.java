package test;

import java.io.*;

public  class Test1 {
	@Override
	public String toString(){
		return "niaho";
	}
	
	public static void main(String[] args){
		File f = new File("c:\\new.txt");
		BufferedInputStream bf = null;
		byte b[] = new byte[1024];
		try {
			bf = new BufferedInputStream(new FileInputStream(f));
//			int g = bf.read(b);
//			for(int i=0;i < g ;i++)
//				System.out.print((char)b[i]);
//			int i = bf.read(b);
//			System.out.print(new String(b,0,i));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
