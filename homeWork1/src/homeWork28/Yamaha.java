package homeWork28;

public class Yamaha implements IEngine {

	@Override
	public boolean start() {
		// TODO Auto-generated method stub
		System.out.println("YAMAHA �������ٶ�60");
		return true;
	}

	@Override
	public boolean stop() {
		// TODO Auto-generated method stub
		System.out.println("YAMAHA ֹͣ���ٶ�0");
		return true;
	}

	@Override
	public int speedup() {
		// TODO Auto-generated method stub
		System.out.println("YAMAHA ���٣��ٶ�80");
		return 0;
	}

}
