package home24;


public class Cat  {
	private int age;
	private int height;
	private int weight;
	private String color;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void eat(){
		System.out.println("Ð¡Ã¨°®³ÔÓã");
	}
	
	public void play(){
		System.out.println("Ð¡Ã¨°®ÍæË£");
	}
	
	public void cat_ch(){
		System.out.println("Ð¡Ã¨Òª×¥ÀÏÊó");
	}
	
//	public String toString(){
//		String str = "Age: "+getAge()+" Weight: "+getWeight();
//	     str += " Height: "+getHeight()+" Color: "+getColor();
//	     return str;
//	}
	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj instanceof Cat){
			Cat cat = (Cat)obj;
			if(age == cat.age && height == cat.height)
			   if(weight == cat.weight && color.equals(cat.color))
				   return true;
		}
		return false;
	}
	
	public Cat(){
	}
	
	public Cat(int age,int weight,int height,String color){
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.color = color;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat1 = new Cat(5,32,12,"yello");
		Cat cat2 = new Cat(5,12,11,"black");
		Cat cat3 = new Cat(5,12,11,"black");
		Cat cat4 = cat3;
		System.out.println(cat3.equals(cat2));
		System.out.println(cat3.equals(cat1));
//		System.out.println("cat1: "+cat1.toString());
//		System.out.println("cat2: "+cat2.toString());
//
//		System.out.printf("%h\n",cat1.hashCode());
//		System.out.printf("%h\n",cat2.hashCode());
//		System.out.printf("%h\n",cat3.hashCode());
//		System.out.printf("%h\n",cat4.hashCode());
	}

}
