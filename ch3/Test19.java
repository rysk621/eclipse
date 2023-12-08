package ch3;

public class Test19 {
	public static void main(String[] args) {

		int score = 90;
		if (score >= 100) {
			System.out.println(score);
			score += 100;
		} else {
			score++;
			score += 10;

			System.out.println(score);
		}

	}

}
// ctrl+shift+F를 선택하여 들여쓰기 줄을 맞추기