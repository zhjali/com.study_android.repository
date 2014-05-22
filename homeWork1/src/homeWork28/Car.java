package homeWork28;

public class Car {
	IEngine engine;
//	String name;
	
	public void testEngine(IEngine engine){
		engine.start();
		engine.stop();
		engine.speedup();
	}
	public void testEngine(){
		engine.start();
		engine.stop();
		engine.speedup();
	}

	public IEngine getEngine() {
		return engine;
	}

	public void setEngine(IEngine engine) {
		this.engine = engine;
	}	

	public Car(){
	}
	
	public Car(IEngine engine) {
		super();
		this.engine = engine;
	}

}
