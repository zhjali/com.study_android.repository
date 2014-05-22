package homeWork28;

public class Honda implements IEngine {

	@Override
	public boolean start() {
		// TODO Auto-generated method stub
		System.out.println("HONDA启动，速度40");
		return true;
	}

	@Override
	public boolean stop() {
		// TODO Auto-generated method stub
		System.out.println("HONDA停止，速度0");
		return true;
	}

	@Override
	public int speedup() {
		// TODO Auto-generated method stub
		System.out.println("HONDA加速，速度120");
		return 0;
	}

}
