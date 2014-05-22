package homeWork3m3.demo01;

public class Array1 {
	public int[] a = {2,3,1,6,34,112};
	int sum = 0;
	int average = 0;
	int max = 0;
	int min = 0;
	
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
			System.out.print(i +": "+a[i] + "\t");
			if( (i+1)%5 == 0)
				System.out.println("");
		}
//		for(int i : a){
//			System.out.println(i);
//		}
	}
	public int getSum(int[] a,int l){
		for(int i = 0;i<l;i++){
			sum += a[i];
		}
		return sum;
	}
	
	public int getMax(int[] a,int l){
		max = a[0];
		for(int i = 0;i<l;i++){
			if(a[i] > max)
				max = a[i];
			if(a[i] < min)
				min = a[i];
		}
		return max;
	}
	
	public int getMin(int[] a,int l){
		min = a[0];
		for(int i = 0;i<l;i++){
			if(a[i] < min)
				min = a[i];
		}
		return min;
	}
	
	public int[] random(int l){
		int[] b = new int[l];
		for(int i=0; i< l ; i++)
			b[i] = (int)(Math.random()*101);
		return b;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Array1 ar = new Array1();
		int l = 18;
		int[] b = ar.random(l);
		ar.print(b, l);
		ar.sort(b, l);
		System.out.println("After sort£º");
		ar.print(b, l);
//		System.out.println("Sum: "+ar.getSum(b, 30));
//		System.out.println("Average: "+ar.getSum(b, 30)/30);
//		System.out.println("Max: "+ar.getMax(b, 30)+" Min: "+ar.getMin(b, 30));

	}

}
