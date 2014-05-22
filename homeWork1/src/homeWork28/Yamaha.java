package homeWork28;

public class Yamaha implements IEngine {

	@Override
	public boolean start() {
		// TODO Auto-generated method stub
		System.out.println("YAMAHA 启动，速度60");
		return true;
	}

	@Override
	public boolean stop() {
		// TODO Auto-generated method stub
		System.out.println("YAMAHA 停止，速度0");
		return true;
	}

	@Override
	public int speedup() {
		// TODO Auto-generated method stub
		System.out.println("YAMAHA 加速，速度80");
		return 0;
	}

}
