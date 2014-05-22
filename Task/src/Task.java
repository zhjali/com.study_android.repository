public class Task {
	Animal animal;

	public void taskA() {
		animal = (Dog) new Dog();
	}

	public static void main(String[] args) {
		new Task().taskA();
		System.out.println("success");

	}
}
