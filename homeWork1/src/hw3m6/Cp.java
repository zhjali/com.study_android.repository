package hw3m6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import work27.Book;
import work27.Person;


public class Cp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p = new Person("a",12);
		Person p1 = new Person("b",13);
		Person p2 = new Person("c",11);
		
		Book b1 = new Book("<Proud and Prejudice>");
		Book b2 = new Book("<Golden Age>");
		Book b3 = new Book("<Lover>");
		
		p.getList().add(b1);
		p.getList().add(b2);
		p.getList().add(b3);
		
		p.printInfor();

		
	}
}
