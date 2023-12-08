package com.ruby.java.ch09;

public class Test01 {
	public static void main(String[] args) {
		String s = new String("Kim");
		String s1 = new String("Hong");
		// if (s < s1) {}; : error 발생(the operator < is undefined for the argument types
		// java.lang.String, java.lang.String)
		if (s.compareTo(s1) < 0) {
			System.out.println("True");
		}

		Object obj1 = new Object(); // 힙 영역에 인스턴스 생성
		Object obj2 = new Object();
		Object obj3 = new Object();

		System.out.println(obj1.hashCode()); // 각 인스턴스의 해시코드값 출력
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode() + "\n");

		System.out.println(obj1.getClass()); // class 이름을 출력
		System.out.println(obj2.getClass());
		System.out.println(obj3.getClass() + "\n");

		System.out.println(obj1.toString());
		System.out.println(Integer.toHexString(obj1.hashCode())); // obj1의 hashcode를 hexadecimal String으로 변환
		System.out.println(Integer.toHexString(925858445));
		System.out.println(obj1 + "\n"); // obj1.toString()과 동일한 출력값. instance를 sysout에 입력 --> println method는 String을
											// 출력할 수 있음. -->
		// --> 자동으로 toString함수를 출력,overriding 되지 않았으므로 Object class의 toString함수를 출력함
		MyObject obj4 = new MyObject();
		MyObject obj5 = new MyObject();
		System.out.println(obj4);
		System.out.println(obj4.toString() + "\n");

		if (obj4.equals(obj5)) {
			System.out.println("동일 객체이다.");
		} else {
			System.out.println("다른 객체이다.");
		}
		if (obj4 == obj5) {
			System.out.println("동일 객체");
			return;
		}
		System.out.println("다른 객체");
	}
}
