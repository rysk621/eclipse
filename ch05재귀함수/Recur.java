package ch05재귀함수;

import java.util.Scanner;

//재귀에 대한 이해를 돕는 순수 재귀 메서드
public class Recur {
	// --- 순수 재귀 메서드 ---//
	static void recur(int n) {
		if (n > 0) {
			recur(n - 1);
			System.out.println(n);
			recur(n - 2);
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("음이 아닌 정수를 입력하세요 : ");
		int x = stdIn.nextInt();
		stdIn.close();

		recur(x);
	}
}
