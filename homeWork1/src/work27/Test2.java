package work27;

public class Test2 {

	public static void main(String[] args){
		System.out.println(args[0]);
		User u1 = new User("nihao","123");
		User u2 = new User("hao","123");
		User u3 = new User("hao",null);
		User u4 = new User("hao","123");
		User u5 = u4;
		
		System.out.println(u1.equals(u2));//false
		System.out.println(u3.equals(u2));//false
		System.out.println(u4.equals(u5)); //true?
		System.out.println((u4==u2)); //true?
		System.out.println((u4==u5)); //true
		
	}
}
