package pnu;

import java.util.ArrayList;

public class StarArrayList3 {
	public static void main(String[] args) {
		// Use Scanner, input times to repeat

		// ArrayList 객체 생성
		ArrayList<String> star = new ArrayList<>();
		int r = 1;
		// 저장할 문자열 생성해서 ArrayList에 저장
		// repeat 횟수만큼 반복(for loop)
		for (; r <= 5; r++) {
//			String starcount = "";
			StringBuffer s = new StringBuffer();
			for (int j = 0; j < r; j++) {
				s.append("*");
			}
			star.add(s.toString());
		}
		// 저장된 문자열 출력
		star.forEach(s->System.out.println(s));
	}
}

/*
 *
 **
 ***
 ****
 *****
 * 
 * 발생
 * 
 */