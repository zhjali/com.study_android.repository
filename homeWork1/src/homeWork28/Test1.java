package homeWork28;

public class Test1 {
	public static void main(String[] args){
		
		Car car = new Car(new  Yamaha());
		car.testEngine();
		car.setEngine(new Honda());
		car.testEngine();
	}
}
