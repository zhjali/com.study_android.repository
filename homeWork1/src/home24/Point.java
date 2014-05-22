package home24;

public class Point {
	int x;
	int y;
	int z;
	double distance;

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public Point() {
	}

	public Point(int x, int y, int z) {
		setX(x);
		setY(y);
		setZ(z);
	}

	// 返回两点距离的平方
	public double getDistance(Point p2) {
		double sqrDistance = Math.pow((this.x - p2.x), 2)
				+ Math.pow((this.y - p2.y), 2) + Math.pow((this.z - p2.z), 2);
		return distance = Math.sqrt(sqrDistance);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point(1, 2, 3);
		Point p2 = new Point(23, 24, 25);
		double Dis = p1.getDistance(p2);
		System.out.printf("distance is :%.2f", Dis);
		// System.out.print("The distance is :" + Dis);

	}
}
