package ch2;

public class Test11 {
	public static void main(String[] args) {
		byte a = (byte) 0b11110100; // (byte): type casting
		System.out.println(a);
		int b = 017; // 8진법은 0으로 시작
		int c = 0xf; // 16진법은 0x로 시작
		System.out.println(b + " " + c);
		
		int f = 12;
		int g = ~f + 1;
		System.out.println(g);
	}

}
