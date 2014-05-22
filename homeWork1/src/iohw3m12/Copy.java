package iohw3m12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Copy {

	public boolean copy(File souFile,File destFile,boolean append) {
		int i = 0;
		boolean flag = true;
		InputStream in = null;
		OutputStream out = null;
		byte[] s = new byte[1024];
		try {
			in = new FileInputStream(souFile);
			out = new FileOutputStream(destFile,append);
			i = in.read(s);
			while(i != -1){
				out.write(s,0,i);
				i = in.read(s);
			}
		} catch (FileNotFoundException e) {
			System.out.println("文件流初始化失败！");
			e.printStackTrace();
			flag = false;
		}  catch (IOException e) {
			System.out.println("文件读写出现问题");
			e.printStackTrace();
			flag = false;
		}	finally{
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				System.out.println("关闭流异常");
				e.printStackTrace();
				flag = false;
			}
		}
		if(flag == true)
			System.out.println("Copy Success!");
		else 
			System.out.println("Copy Failure!");
		return flag;
	}

	public static void main(String[] args) {
		Copy copy = new Copy();
		 boolean append = false;
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("1: 覆盖复制\t2:追加复制");
		 if(scanner.nextInt() == 2)
		 append = true;
		 System.out.println("输入源文件路径：");
		 File souFile = new File(scanner.next());
		 System.out.println("输入目标文件路径：");
		 File destFile = new File(scanner.next());
//		copy.copy(new File("c:\\1.txt"), new File("c:\\2.txt"), true);
		copy.copy(souFile, destFile, append);
	}
}
