package homeWork28;

public class Honda implements IEngine {

	@Override
	public boolean start() {
		// TODO Auto-generated method stub
		System.out.println("HONDA�������ٶ�40");
		return true;
	}

	@Override
	public boolean stop() {
		// TODO Auto-generated method stub
		System.out.println("HONDAֹͣ���ٶ�0");
		return true;
	}

	@Override
	public int speedup() {
		// TODO Auto-generated method stub
		System.out.println("HONDA���٣��ٶ�120");
		return 0;
	}

}
