package hw3m14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAcc {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\1.txt");
		RandomAccessFile ran = new RandomAccessFile(file, "rw");
		String[] name = { "mailoaoer", "zhuding", "zhujiji" };
		Integer[] age = { 23, 43, 64 };
		Double[] score = { 45.2, 69.3, 90.9 };
		long[] index = new long[3];
		for(int i = 0 ; i<name.length ; i++){
			ran.writeUTF(name[i]);
			ran.writeInt(age[i]);
			ran.writeDouble(score[i]);
			index[i] = ran.getFilePointer();
		}
		ran.seek(index[0]);
		String name1 = ran.readUTF();
		int age1 = ran.readInt();
		double socre1 = ran.readDouble();
		System.out.println(name1 + "\t" + age1 +"\t" + socre1);
		
		ran.seek(0);
		name1 = ran.readUTF();
		age1 = ran.readInt();
		socre1 = ran.readDouble();
		System.out.println(name1 + "\t" + age1 +"\t" + socre1);
		
		ran.seek(index[1]);
		name1 = ran.readUTF();
		age1 = ran.readInt();
		socre1 = ran.readDouble();
		System.out.println(name1 + "\t" + age1 +"\t" + socre1);

		ran.seek(0);
		Student st1 = new Student(ran);
		System.out.println(st1);
	}
}
