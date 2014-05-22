
public class Animal {

	String category;
	int life;
	
	
	public Animal(){
		this("Human",100);
	}
	
	public Animal(String category,int life){
		this.category = category;
		this.life = life;
	}
	
	public void eat(){
		System.out.println("ÕýÔÚ³Ô¡­¡­");
	}
	
	public void infor(){
		System.out.println("Category: "+category+"life: "+life);
	}
}
