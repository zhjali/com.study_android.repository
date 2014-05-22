public class Dog extends Animal {
	private String leg;

	public static void main(String[] args) {
		Animal animal = new Animal();
		Dog dog = (Dog) animal;
		System.out.println("success");
	}
}
