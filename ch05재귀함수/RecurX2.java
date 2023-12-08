package ch05재귀함수;

import java.util.Scanner;

//재귀에 대한 이해를 돕는 순수 재귀 메서드(재귀를 제거)
public class RecurX2 {
	// --- 재귀를 제거한 recur ---//
	static void recur(int n) {
		IntStack s = new IntStack(n);

		while (true) {
			if (n > 0) {
				s.push(n); // n 값을 푸시: 스택에 입력한 데이터를 임시 저장
				n--; // n에 n-1을 저장
				continue; // continue문으로 while문 시작지점으로 되돌아감. n>0인 동안에 if문 계속 진행. n=0값이 저장되면 if문 지나가고,
							// 스택 s가 비어있는지 확인 후 비어있지 않으면 두번째 if문 시작
			}
			if (!s.isEmpty()) { // 스택이 비어 있지 않으면 if문 진행
				n = s.pop(); // 저장하고 있던 값을 n에 팝: 꼭대기 값부터 pop하여 n에 저장 후
				System.out.println(n); // pop한 값 n을 출력한다.
				n = n - 2; // n에 n-2를 저장, 스택이 빌 때까지 두번째 if문 진행.
				continue;
			}
			break;
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("정수를 입력하세요 : "); // 입력한 정수를 capacity로 갖는 IntStack 생성
		int x = stdIn.nextInt();
		stdIn.close();

		recur(x);
	}
}
