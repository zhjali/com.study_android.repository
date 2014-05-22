package hw3m10;

public class TestRefer {
	
	public static void a(StringBuffer string){
		string.append("nihao");
		string.append("nihao");
	}
	
	public static void main(String[] args) {
		StringBuffer string = new StringBuffer("niahao");
		TestRefer.a(string);
		System.out.println(string);	
		string.trimToSize();
		for(int i = 0;i<string.capacity();i++)
		System.out.println((char)string.codePointAt(i));
	}
}
