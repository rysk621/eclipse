package ch2;

public class Test05 {
	public static void main(String[] args) {
		int A1 = 10;
		A1++; // = A1 + 1
		int A2 = -A1;
		A2 += 10;
		System.out.println(A1);
		int A3 = A1++ + A2++; // A2++는 연산에 포함되지 않음, 연산식 진행 후 A2 값에 +1
		System.out.println(A3);
		System.out.println("A1 = " + A1 + ", A2 = " + A2);
		System.out.println(A1 == A2); // 비교연산자의 결과는 T/F
		
		char gender = 'F';
		int balance = 100;
		System.out.println(gender !='F' && balance > 10);
		// System.out.println(gender !='F' & balance++ > 10); and연산자 뒤의 식을 진행해야 할 때는 && 말고 & 사용해야함
		System.out.println(!(gender !='F') || balance > 10); // |, ||: or 연산자
	}

}
