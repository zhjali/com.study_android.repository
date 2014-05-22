package homeWork3m3.demo01;

public class Array {
	double[] d;
	String[] s = {"nihao","hello","woshi","h","5ge"};
	
	public Array(){
		d = new double[5];
		d[0] = 0;
		d[1] = 2;
		d[4] = 5;
		}
		
	public static void main(String[] args){		
		Array a = new Array();
		for(int i=0; i<5;i++){
			System.out.println(a.d[i]);
			System.out.println(a.s[i]);
			}
		}
}
