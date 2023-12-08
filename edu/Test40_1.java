package edu;

public class Test40_1 {
	private static int sum(int a, int b) {
		System.out.println("sum1");
		int result = a + b;
		return result;
	}
	private static int sum(int a, int b, int c) {
		System.out.println("sum2");
		int result = a + b + c;
		return result;
	}

	public static void main(String[] args) {
		int s = sum(10, 20);
		System.out.println("sum : " + s); // 변수 선언하는 방식
		s = sum(10, 20, 30);
		System.out.println("sum : " + s); // 변수 선언하는 방식
	}
}
