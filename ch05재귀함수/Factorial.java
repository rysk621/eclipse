package ch05재귀함수;
//팩토리얼 값을 재귀적으로 구함

import java.util.Scanner;

public class Factorial {
	// --- 음이 아닌 정수 n의 팩토리얼 값을 반환 ---//
	static int factorial(int n) {
		if (n != 0)
			return n * factorial(n - 1);
		else
			return 1;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

//		음수를 입력시 stackoverflow error 발생함.
		System.out.print("음이 아닌 정수를 입력하세요 : ");
		int x = stdIn.nextInt();

		System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
		stdIn.close();
	}
}