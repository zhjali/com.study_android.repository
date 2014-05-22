package hw3m6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Collection<Integer> cl =  new ArrayList<Integer>();
		int sum = 0;

		cl.add(new Integer(23));
		cl.add(new Integer(45));
		cl.add(new Integer(24));
		cl.add(new Integer(78));
		cl.add(new Integer(54));
		cl.add(new Integer(32));
		Iterator<Integer> i = cl.iterator();
		System.out.println(cl);
		while(i.hasNext()){
			if(i.next() == 54)
				i.remove();
			System.out.println(i.next());
		}
	}

}
