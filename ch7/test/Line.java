package ch7.test;

class Line extends Geometry{
	public Line() {
	}
	
	public Line(int x, int y) {
		
	}

	@Override
	public double getLength() {
		int[] xArr = getxArr();
		int[] yArr = getyArr();
		return xArr[0] - yArr[0];
	}

	private int[] getyArr() {
		// TODO Auto-generated method stub
		return null;
	}

	private int[] getxArr() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getArea() {
		return 0;
	}
}
