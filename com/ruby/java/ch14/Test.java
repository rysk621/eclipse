package com.ruby.java.ch14;

public class Test {
	public static void main(String[] args) {
		String a = "Hello, World!";
		a.length(); //declaration 필요없음, length method.
		System.out.println(a.length());
		
		int b = 12345;
		int[] c = {1,2,3,4,5};
		int d = c.length; //declaration 필요함, int type parameter는 length state 사용할 수 없음. int array type parameter c에는 length state 내장되어 있어서 사용 가능
		System.out.println(d);
	}
}
