package work27;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Person {
	int age;
	String name;
	List<Book> list;

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
	public List<Book> getList() {
		return list;
	}
	public void setList(List<Book> list) {
		this.list = list;
	}


	public void infor(Person p){
		System.out.println(p.name + ":"+p.age);
	}

	public Person(){
		this.list = new ArrayList<Book>();
	}
	
	
	public Person(String name, int age) {
		this();
		this.name = name;
		this.age = age;
	}
	

	public Person(String name, int age, List<Book> list) {
		this(name, age);
		this.list = list;
	}
	
	public void printBook(){
		Iterator<Book> i = this.getList().iterator();
		while(i.hasNext()){
			System.out.println(i.next().toString());
		}
	}
	public void printInfor(){
		System.out.println("Name: " + this.name);
		System.out.println("Age: " + this.age);
		System.out.println("Books: ");
		
		Iterator<Book> i = this.getList().iterator();
		while(i.hasNext()){
			System.out.println("\t"+i.next().toString());
		}
		System.out.println("++++++++++++++++++");
	}
}
