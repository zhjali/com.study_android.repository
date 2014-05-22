package homeWork3m3.demo01;

import java.util.*;

public class Test01 {

	public int[] sort(int [] a,int l){
		int temp = a[0];
		for(int i= 0;i<l-1;i++){
			for(int j = 0;j<l-1;j++){
				if(a[j]>a[j+1]){
					temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}
	
	public void print(int[] a,int l){
		for(int i = 0;i<l;i++){
			System.out.println(a[i]);
		}
	}


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Test01 ar = new Test01();
		int l = 10;
		int[] b =new int[10];
		for(int i = 0;i<l;i++){
			b[i] = scan.nextInt();
		}
		ar.sort(b, l);
		ar.print(b, l);
	}

}
