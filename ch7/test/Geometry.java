package ch7.test;

public abstract class Geometry {
	private int[] xArr = new int[4];
	private int[] yArr = new int[4];
	
	public abstract double getLength();
	public abstract double getArea();
	
	void addPoint(int x, int y) {
		xArr[0] = x;
		yArr[0] = y;
		System.out.println();
	}
	/*
	 * int[] getXArr() { return xArr; } int[] getYArr() { return yArr; }
	 * 
	 * public void printPoint() { for (int i = 0; i < xArr.length ; i++) {
	 * System.out.println(xArr[i]+", "+yArr[i]); } }
	 */
}
