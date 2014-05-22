
public class Dog extends Animal {
	String skill;
	String name;
	
	public Dog(){
		this("Dog",10);
		super.infor();
	}
	
	public Dog(String category,int life){
		this.category = category;
		this.life = life;
	}
	
	public void infor(){
		super.infor();
	}
	
	public  static void main(String [] args){
		Dog dog = new Dog();
		dog.infor();
	}
}
