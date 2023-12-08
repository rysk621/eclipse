package ch3;

public class Test01 {

	public static void main(String[] args) {
		int score = 90;
		int bonus;
		if (score < 100) {
			bonus = 10;
		} else if (score < 200) { // 100<score<200 형태 불가능, 100<score & score<200
			bonus = 20;
		} else
			bonus = 30;
		score += bonus;
		System.out.println(score);
	}

}
