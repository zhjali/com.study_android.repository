package iohw3m12;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class TaskInput {
	public static void main(String[] args) throws IOException{
		File file = new File("E:\\WWW\\phpMyAdmin\\examples\\upgrade_tables_mysql_4_1_2+.sql");
		int count = 0;
		InputStream in;
			 in= new FileInputStream(file);
		BufferedInputStream bf = new BufferedInputStream(in);
		byte[] b = new byte[1024];
		int i = bf.read(b);
		while(i != -1){
		System.out.print(new String(b,0,i));
		count += i;
		i = bf.read(b);
		}
		System.out.println();
		System.out.println("读入了"+count+"个字节。");
			
	}
}
