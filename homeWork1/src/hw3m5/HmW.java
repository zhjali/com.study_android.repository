package hw3m5;

public class HmW {
	//count the string of 'dest' appear in the 'sour' String.

	public static int countJ(String sour,String dest){
		int index = 0;
		int count = 0;
		while(true){
			index = sour.indexOf(dest, index);
			if(index != -1){
				count++;
				System.out.println(index);
			}
			else
				break;
			index += dest.length();
		}
		return count;
	}
	
	public static void printComposite(String sour){
		int l = sour.length();
		int j = 0;
		int temp = 0;
		int m = 0;
		boolean flag = false;
		
		for(int i = 0; i<l ;i++){
			temp = i;
			if(l-i < 8){     //打印行数将少于8次,flag开启
				j = 8-(l-i);
				flag = true;
			}	
			for( ; j<8 ; j++ ){
				for(int k = 0; k <= j && !flag ; k++){
					System.out.print(sour.charAt(i));
					i++;
				}
				
				for(int k = 0; k <= m && flag ; k++){
					System.out.print(sour.charAt(i));
					i++;
				}
				m++;
				i = temp;
				System.out.println("");
			}
			System.out.println("");
			j = 0;
			m = 0;
		}
	}

	public static int[][] saveArray(String str){
		String[] s = str.split("!");
		String[][] s1 = new String[s.length][];
		int[][] a = new int[s.length][];
		
		for(int i = 0; i<s.length ; i++){
			s1[i] = s[i].split(",");
			a[i] = new int[(s1[i].length)];
		}
		
		for(int i = 0; i<s1.length ; i++)
			for(int j = 0; j<s1[i].length ; j++ )
				a[i][j] = Integer.parseInt(s1[i][j]);
		return a;
	}
	
	public static void printA(int[][] a){
		for(int i = 0; i<a.length ; i++){
			for(int j = 0; j<a[i].length ; j++ )
				System.out.print(a[i][j]+" ");
			System.out.println("");
		}
	}
	public static void main(String[] args){
//		String str = "sunjavaandroidjavajavasejavaeejavamec#java.netjavaphpjava";
//		System.out.println(HmW.countJ(str, "java"));
//		String str1 = "ABCDEFGHIJK";
		String str2="1,2,3!4,5,6,0!7,8,9";
//		HmW.printComposite(str1);
		int[][] a = null;
		a = HmW.saveArray(str2);
		HmW.printA(a);
	}
	
}
