package com.ruby.java.ch13;

public class GenMethodTest {
	static <T extends Number, V extends T> boolean isInclude(T num, V[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == num)
				return true;
		}
		return false;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Integer[] inum = { 1, 2, 3, 4, 5 }; // boxing: inum을 class처럼 이용해 inum.으로 method call하기 위해 int[] 아니고 Integer[]로 작성
		Double[] dnum = { 1.0, 2.0, 3.0, 4.0, 5.0 };
		String[] snum = { "one", "two", "three", "four", "five" }; // T extends Number로 선언되었으므로 Number type 아닌 String은 T
																	// type generic에 해당되지 않음

		boolean b1 = isInclude(3, inum); // int, Integer[] : autoboxing. T and V를 int type으로 다시 코딩해서(compiler level) <T, V> for문에 insertion
		System.out.println("결과 : " + b1);

		boolean b2 = isInclude(5.0, dnum);
		System.out.println("결과 : " + b2);

//		boolean b3 = isInclude("one", snum);

		GenMethodTest.<Integer, Integer>isInclude(3, inum); // 이렇게 호출할 수도 있다.
		System.out.println(GenMethodTest.<Double, Double>isInclude(5.0, dnum));
//		GenMethodTest.<String, String>isInclude("one", snum);		
	}
}
