package test;


/**
*ÊäÈëĞ¡Ğ´×ÖÄ¸ a l Êä³ö a b c d e f g h i j k l
**/

public enum Web {
	Mon(0),Tue(1),Wed(2),Thu(3),Fri(4),Sat(5),Sun(6);
	
	private int value;
	
	public int getValue(){
		return value;
	}
	public void setValue(int value){
		this.value = value;
	}
	
	Web(int value){
		this.setValue(value);
	}
	

	public static void main(String[] args) {
		for(Web w: Web.values()){
			System.out.println(w.ordinal());
		}
		
	}
}
