package hw3m14;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ScoreList {
	public static void main(String[] args) throws IOException {
		String[] name = { "mailoaoer", "zhuding", "zhujiji" };
		File file = new File("C:\\1.txt");
		DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		Integer[] age = { 23, 43, 64 };
		Double[] score = { 45.2, 69.3, 90.9 };
		for (int i = 0; i < name.length; i++) {
			out.writeUTF(name[i]);
			out.writeInt(age[i]);
			out.writeDouble(score[i]);
			out.flush();
		}
		for(int i = 0; i< name.length ; i++){
			String name1 = in.readUTF();
			int age1 = in.readInt();
			double socre1 = in.readDouble();
			System.out.println(name1 + "\t" + age1 +"\t" + socre1);
		}
	}
}
