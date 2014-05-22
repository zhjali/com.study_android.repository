import java.util.*;
public class Web {
	public int[] bubbelSort(int[] a){
		int temp = 0;
		for(int i = 0; i<(a.length-1); i++)
			for(int j = 0;j<(a.length-1);j++ )
				if(a[j] > a[j+1]){
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
		return a;
	}
	public  void print(int[] a){
		int length = a.length;
		
		for(int i = 0;i<length;i++){
			System.out.print(i+a[i] + "\t");

		}
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Web w = new Web();
//		char[] ch = scan.next().toCharArray();
		int[] a = new int[10];
//		for(int i = 0; i<a.length ;i++)
		a[0] = scan.nextInt();
		a[1] = scan.nextInt();
		a[2] = scan.nextInt();
		a[3] = scan.nextInt();
		a[4] = scan.nextInt();
		a[5] = scan.nextInt();
		a[6] = scan.nextInt();
		a[7] = scan.nextInt();
		a[8] = scan.nextInt();
		a[9] = scan.nextInt();
		w.print(a);
		w.bubbelSort(a);
		w.print(a);
	
	}
}
