package edu;

public class Test40 {
	private static int sum(int a, int b) {
		int result = a + b;
		return result;
	}

	private static double avg(int... a) {
		double sum = 0.0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum / a.length;
	}

	private static int min(int... a) {
		// 최소값을 저장할 변수 선언 및 초기화. a[0]값과 나머지를 비교하면 되므로 초기화 값은 a[0]로 하면 됨.
		int min_num = a[0];
		// 리스트 a의 가변 길이만큼 루프 반복
		for (int i = 1; i < a.length; i++) // a[0]로 초기화 해서 int i=0부터 시작할 필요 없음.
			if (min_num > a[i])
				min_num = a[i];
		return min_num;
	}

	private static int max(int... a) {
		int max_num = a[0];
		for (int i = 1; i < a.length; i++)
			if (max_num < a[i])
				max_num = a[i];
		return max_num;
	}

	public static void main(String[] args) {
		int s = sum(10, 20);
		System.out.println("sum : " + s); // 변수 선언하는 방식

		System.out.println("avg : " + (int) avg(1, 2, 3, 4, 5)); // 변수 선언하지 않는 방식. 우열은 없고 필요에 따라 사용

		System.out.println(min(1, 5, 9, 0, -4));

		int max = max(6, 4, 7, 8, 0);
		System.out.println(max);
	}
}
