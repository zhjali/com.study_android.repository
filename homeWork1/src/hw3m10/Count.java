package hw3m10;

import javax.xml.transform.Templates;

public class Count {
	int A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z;
	int count;
	
	public void count1(String string){
		A = 0; B = 0; C = 0; D = 0; E = 0; F = 0;
		G = 0; H = 0; I = 0; J = 0; K = 0; L = 0;
		M = 0; N = 0; O = 0; P = 0; Q = 0; R = 0;
		S = 0; T = 0; U = 0; V = 0; W = 0; X = 0;
		Y = 0; Z = 0;
		char[] ch = string.toCharArray();
		for(int i = 0; i<ch.length ; i++){
			switch (ch[i]) {
			case 'A':
				A++;
			case 'B':
				B++;
			case 'C':
				C++;
			case 'D':
				D++;
			case 'E':
				F++;
			case 'G':
				G++;
			case 'H':
				H++;
			case 'I':
				I++;
			case 'J':
				J++;
			case 'L':
				L++;
			case 'M':
				M++;
			case 'N':
				N++;
			case 'O':
				O++;
			case 'P':
				P++;
			case 'Q':
				Q++;
			case 'R':
				R++;
			case 'S':
				S++;
			case 'T':
				T++;
			case 'U':
				U++;
			case 'V':
				V++;
			case 'W':
				W++;
			case 'X':
				X++;
			case 'Y':
				Y++;
			case 'Z':
				Z++;
				
				break;

			default:
				break;
			}
		}
	
	}
	
	public void count2(String string){
		count = 0;
		for(int i = 0; i<26 ; i++){
			char ch = (char) ('A'+i);
			for(int j = 0; j < string.length(); j++){
				if(string.charAt(j) == ch)
					count++;
			}
			System.out.println(ch+":"+count);
			count = 0;
		}
		count = 0;
	}

	public void count3(String string){
		char ch;
		String temp = null;
		
		for(int i = 0; i<26 ; i++){
			ch = (char) ('A'+i);
			temp = string.replace(ch, '!');
			temp += "&";
			String[] st1 = temp.split("!");
			System.out.println(ch+":"+(st1.length-1));
		}
		
	}

	public void count4(String string){
		char ch;
		String temp = null;
		
		for(int i = 0; i<26 ; i++){
			ch = (char) ('A'+i);
			temp = string.replace(ch,(char)0);
			System.out.println(ch+":"
					+((sumString(string)-sumString(temp))/(int)ch));
		}
	}
	
	public void count5(String string){
		count = 0;
		char ch;
		int index = 0;
		
		for(int i = 0; i<26 ; i++){
			ch = (char) ('A'+i);
			index = string.indexOf(ch,index);
			while(index != -1){
				count++;
				index = string.indexOf(ch,index+1);
			}
			System.out.println(ch+":"+count);
			count = 0;
			index = 0;
		}
	}

	public int sumString(String string){
		int sum = 0;
		int length = string.length();
		for(int i = 0; i<length ; i++)
			sum += string.charAt(i);
		return sum;
	}
	
	public static void main(String[] args) {
		String string = "ECALIYHWEQAEFSZCVZTWEYXCPIURVCSWTDBCIOYXGTEGDTUMJHUMBJKHFGUKNKN";
		Count cou = new Count();
		cou.count2(string);
		cou.count3(string);
		int i = 1;
		System.out.println((char)i+"nihao");
		cou.count4(string);
		cou.count5(string);
//		System.out.println(string.indexOf('A'));
		
	}
}
