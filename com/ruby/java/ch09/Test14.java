package com.ruby.java.ch09;

import java.util.StringTokenizer;

public class Test14 { // StringTokenizer test
	public static void main(String[] args) {
		String msg = "with great power comes great responsibility, said uncle Ben.";
		StringTokenizer st1 = new StringTokenizer(msg); // error 발생 --> import StringTokenizer 해야함
		System.out.println("token 수(단어 수) : " + st1.countTokens()); // token 들의 집합을 나타내는 객체

		System.out.println("\n" + "=".repeat(10));
		String s = "id=guest&name=Amy&pwd=1004";

		StringTokenizer st2 = new StringTokenizer(s, "&"); // 생성자의 2번째 인자에 구분자를 넣을 수 있다. (& : ampersand)
		while (st2.hasMoreTokens()) {
			System.out.println("남아있는 token 수 : " + st2.countTokens());
			System.out.println(st2.nextToken());
		}

		System.out.println("\n" + "=".repeat(10));
		StringTokenizer st3 = new StringTokenizer(s, "=&");
		while (st3.hasMoreTokens()) {
			System.out.println("남아있는 token 수 : " + st3.countTokens());
			System.out.println(st3.nextToken());
		}

	}
}
