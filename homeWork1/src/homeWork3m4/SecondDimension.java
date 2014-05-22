package homeWork3m4;

public class SecondDimension {
	static int sum = 0;
	static int max;
	static int min;
	
	public static int getSum(int[][] a){
		for(int i = 0 ; i<a.length ; i++)
			for(int j = 0 ; j<a[i].length ; j++)
				sum += a[i][j];
		System.out.println("Sum: "+sum);
		return sum;
	}
	
	public static void print(int[][] a){
		for(int i = 0 ; i<a.length ; i++)
			for(int j = 0 ; j<a[i].length ; j++)
				System.out.println(a[i][j]);
	}
	
	public static int getMax(int[][] a){
		max = a[0][0];
		for(int i = 0 ; i<a.length ; i++)
			for(int j = 0 ; j<a[i].length ; j++)
				if(max < a[i][j])
					max = a[i][j];
		return max;
				
	}	
	public static int getMin(int[][] a){
		min = a[0][0];
		for(int i = 0 ; i<a.length ; i++)
			for(int j = 0 ; j<a[i].length ; j++)
				if(min > a[i][j])
					min = a[i][j];
		return min;
	}
	public static void getIndex(int[][] a,int num){
		boolean flag = true;
		int i = 0;
		int j = 0;

		for(i = 0 ; i<a.length && flag ; i++)
			for(j = 0 ; j<a[i].length && flag; j++)
				if(a[i][j] == num)
					flag = false;
		if(!flag)
			System.out.println("The num "+ num +",line = "+i+" column= "+j);
		else
			System.out.println("Can't find the number "+ num);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] a = {{12,34,21},{23,84,10,49},{43,10}};
		SecondDimension.print(a);
		SecondDimension.getSum(a);
		System.out.println("Max: " + SecondDimension.getMax(a));
		System.out.println("Min: " + SecondDimension.getMin(a));
		SecondDimension.getIndex(a,43);
		SecondDimension.getIndex(a,430);
		
	}

}
