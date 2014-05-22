package iohw3m12;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DemoOutputStream01 {

	public static void main(String[] args) throws IOException {
		// 需求：将数据存入到本地文件
		String s1 = "helloworld";
		File f1 = new File("c:\\pro\\bb.txt");
		// step1:声明流：流向，单位
		OutputStream os = null;
		// step2:创建流
		os = new FileOutputStream(f1);
		// step3:操作数据
		os.write(97);// 将单个字节写入到本地文件
		for (int i = 0; i < s1.length(); i++) {
			os.write(s1.charAt(i));
		}
		System.out.println("差不多写完了。。。");

		byte[] b = { 97, 98, 99, 100, 101 };
		os.write(b);// 将整个数组的数据写到文件中

		os.close();
		// 练习1：将字符串，写入本地文件，将字节数组，写入本地文件。
		// 练习2：write(byte[]b,int off,int len);
		// 练习3：如果文件不存在，写操作自动创建文件后，再写，如果文件夹不存在呢？

	}

}
