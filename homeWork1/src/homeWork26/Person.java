package homeWork26;

/**
 * can marry?
 * @author Administrator
 *
 */
public class Person {
	String name;
	int age;
	boolean isMan;  
	Person partner;
	
	public boolean canMarry(Person p){
		int error = 4; //it can marry when error = 0
		//true: can marry
		if(this.isMan == p.isMan){ //false:same gender
			System.out.println("Error: same gender");
			error--;
		}
		if(this.partner != null && p.partner !=null){
			System.out.println("Error: She or he have a partner");
			error--;
		}
		if(this.isMan == false && this.age < 22){
			System.out.println("Error: Her age is not enough");
			error--;
		}
		if(this.isMan == true && this.age  < 24){
			System.out.println("Error: His age is not enough");
			error--;
		}
		if(error == 0){
			System.out.println("Congratulation! ");
			return true;
		}else
			return false;
		}			
}

