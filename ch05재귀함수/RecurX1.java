package ch05재귀함수;
//재귀에 대한 이해를 돕는 순수 재귀 메서드(꼬리 재귀를 제거)

import java.util.Scanner;

public class RecurX1 {
	// --- 꼬리 재귀를 제거한 recur ---//
	static void recur(int n) {
		while (n > 0) { // if (n > 0)을 while문으로 변경하여 loop를 돌도록 한다.
			recur(n - 1);
			System.out.println(n);
			n = n - 2;
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("정수를 입력하세요 : ");
		int x = stdIn.nextInt();
		stdIn.close();

		recur(x);
	}
}
