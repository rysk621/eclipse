package com.ruby.java.ch09;

public class Test02 {
	public static void main(String[] args) {
		String s1 = new String("java"); // instance, heap memory에 존재
		String s2 = new String("java");
		String s3 = "java"; // local variable, stack memory
		String s4 = "java";
		System.out.println("인스턴스 " + s1 + " : 문자열 " + s3);
		// s1==s2인가?
		// s3==s4인가?
		if (s1 == s2) {
			System.out.println("동일 객체이다.");
		} else {
			System.out.println("다른 객체이다."); // s1!=s2이다. s1과 s2는 각 instance의 참조값을 전달받는 참조변수이기 때문
		}
		if (s3 == s4) {
			System.out.println("동일 객체이다." + "\n");
		} else {
			System.out.println("다른 객체이다." + "\n");
		}

		if (s1.equals(s2)) {
			System.out.println("동일 문자열을 가집니다.");
		} else {
			System.out.println("다른 문자열을 가집니다.");
		}
		if (s3.equals(s4)) {
			System.out.println("동일 문자열을 가집니다.");
		} else {
			System.out.println("다른 문자열을 가집니다.");
		}
		System.out.println();

		String s5 = "JAVA";
		if (s1.equals(s5)) {
			System.out.println("동일 문자열을 가집니다.");
		} else {
			System.out.println(s1 + ", " + s5 + " 다른 문자열을 가집니다.");
		}
		if (s1.equalsIgnoreCase(s5)) { // ignore case method: uppercase letter인지 lowercase letter인지는 무시합니다.
			System.out.println("동일 문자열을 가집니다.");
		} else {
			System.out.println("다른 문자열을 가집니다.");
		}
	}
}
