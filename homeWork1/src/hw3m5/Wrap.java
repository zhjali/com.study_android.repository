package hw3m5;

public class Wrap {
	public static void main(String[] args) {
		String[] s = new String[8];
		int i = 1;
		byte b = 2;
		char c = 'a';
		short sh = 3;
		long l = 4;
		float f = 2.3f;
		double d = 4.5;
		s[0] = String.valueOf(i);
		s[1] = String.valueOf(b);
		s[2] = String.valueOf(c);
		s[3] = String.valueOf(sh);
		s[4] = String.valueOf(l);
		s[5] = String.valueOf(f);
		s[6] = String.valueOf(d);
		s[7] = "nihao";
		for (int j = 0; j < s.length; j++)
			System.out.println(s[j]);
		System.out.println(Integer.parseInt(s[0]));
		System.out.println(Byte.parseByte(s[1]));

	}
}
