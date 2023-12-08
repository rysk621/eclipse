package ch3;

public class Test30 {
	public static void main(String[] args) {
		int i=6;
		if((i%2)==0) {
			if((i%3)==0) {
				System.out.println(i+"는 2, 3의 배수입니다.");
			}
		}
		
		for(i=0;i<10;i++) {
			for(int j = 0; j<10;j++) {
				System.out.println(i*j);
			} //variable j의 scope(유효범위)는 여기 for문으로 한정됨
		}
	}

}
