package ch05재귀함수;

//유클리드 호제법으로 최대공약수를 구함

import java.util.Scanner;

public class EuclidGCD {
	// --- 정수 x, y의 최대공약수를 구하여 반환 ---//
	static int gcd(int x, int y) {
		if (y == 0)
			return x;
		else
			return gcd(y, x % y); // gcd() method에 (y, x를 y로 나눈 나머지)를 전달
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("두 정수의 최대공약수를 구합니다.");

		System.out.print("정수를 입력하세요 : ");
		int x = stdIn.nextInt();
		System.out.print("정수를 입력하세요 : ");
		int y = stdIn.nextInt();

		System.out.println("최대공약수는 " + gcd(x, y) + "입니다.");
		stdIn.close();
	}
}
