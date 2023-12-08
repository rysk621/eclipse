package ch3;

public class Test25 {

	public static void main(String[] args) {
		int a = 0;
		int d = 5;
		/*
		 * for (int i=0; i <1; i++) { System.out.println("i = " + i + ", a = "+a); a +=
		 * d; }
		 */
//		System.out.println("a = "+a); //an=an-1 + d (등차수열)
		
		int i = 0;
		while (i<5) {
			System.out.println("i = " + i + ", a = "+a);
			a += d;
			i++;
		}
		
		//do-while문
		int j = 0;
		do {
			System.out.println("j= "+ j+ ", a = "+a);
			a+=d;
			j++;
		}while(j<5);
	}

}
