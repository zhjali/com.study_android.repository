import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;


public class B {

Comparator<A> comparator1 = new Comparator<A>() {

	@Override
	public int compare(A o1, A o2) {
		if(o1.i < o2.i){
			return -1;
		}else if (o1.i > o2.i){
			return 1;
		}
		return 0;
	}
};
Comparator<A> comparator2 = new Comparator<A>() {
	
	@Override
	public int compare(A o1, A o2) {
		if(o1.i > o2.i){
			return -1;
		}else if (o1.i < o2.i){
			return 1;
		}
		return 0;
	}
};

ArrayList<A> as = new ArrayList<A>();

public static void main(String[] args) {
	B b = new B();
	b.as.add(new A(1,2));
	b.as.add(new A(3,2));
	b.as.add(new A(4,2));
	b.as.add(new A(5,2));
	b.as.add(new A(6,2));
	b.as.add(new A(7,2));
	
	for(A a: b.as){
		System.out.println(a);
	}
	
	System.out.println("----------------------");
	Collections.sort(b.as, b.comparator2);
	for(A a: b.as){
		System.out.println(a);
	}
}

}
