package pnu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StarArrayList {
	public static void main(String[] args) {
		//Use Scanner, input times to repeat
		Scanner scan = new Scanner(System.in);
		System.out.print("input times to repeat(1 이상의 자연수): ");
		
		//ArrayList 객체 생성
		List<String> star = new ArrayList<>();
		
		//저장할 문자열 생성해서 ArrayList에 저장
			//repeat 횟수만큼 반복(for loop)
		int rpt = scan.nextInt();
		for (int l = 1;l<=rpt;l++) {
			String starcount = "*".repeat(l);
			star.add(starcount);
		}
		//저장된 문자열 출력
		//System.out.println(star);
		star.forEach(s->System.out.println(s));
//		for (int i =0; i<star.size();i++) {
//			System.out.println(star.get(i));
//		}
		scan.close();
	}
}

/*

*
**
***
****
*****
발생

 */