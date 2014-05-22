package hw3m14;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Student {
	String name;
	int age;
	int score;
	
	public Student(String name, int age, int score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}
	
	public Student(RandomAccessFile rdf){
		try {
			this.name = rdf.readUTF();
			this.age = rdf.readInt();
			this.score = rdf.readInt();
		} catch (IOException e) {
			System.out.println("RandomAccessFile read fail!");
			e.printStackTrace();
		}
	}
	
	public float writeMsg(RandomAccessFile rdf){
		float pointer = 0;
		try {
			rdf.writeUTF(this.name);
			rdf.writeInt(this.age);
			rdf.writeInt(this.score);
			pointer = rdf.getFilePointer();
		} catch (IOException e) {
			System.out.println("RandomAccessFile write fail!");
			e.printStackTrace();
		}
		return pointer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score
				+ "]";
	}
	
}
