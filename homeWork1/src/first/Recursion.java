package first;

public class Recursion {

	static public int rabbit(int month) {
		if (month == 1 || month == 2)
			return 1;
		else
			return rabbit(month - 1) + rabbit(month - 2);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Recursion.rabbit(9));
		System.out.println(Recursion.rabbit(10));
		System.out.println(Recursion.rabbit(11));

	}

}
