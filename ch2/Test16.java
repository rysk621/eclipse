package ch2;

public class Test16 {
	public static void main(String[] args) {
		byte a = 23;
		int b = a; // int b = a; 로 type casting하면 1byte --> 4byte로 변환됨, 가능. but it is implicite type casting이므로 좋지 않다. explicitly type casting 하려면 (int)a로 order해야함)
		System.out.println(b);
		System.out.println((byte)b); // 가능
		
		int c = 23;
		byte d = (byte)c; // integer를 byte로 변환함 --> 문제 발생할 수 있으므로 주의. byte = -128 ~ 127 (-2^7 ~ 2^7-1), 
		
		System.out.println((double)d); // byte --> double type casting
	}

}
