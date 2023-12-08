package com.ruby.java.ch11;

public class Test01 {
	public static void main(String[] args) {
		try {
			int arr[] = new int[3];
			arr[3] = 30; //ArrayIndexOutOfBoundsException
			System.out.println("OK");
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace(); //error code: Stack의 trace를 찾을 때
			System.out.println("오류 발생 : "+e.getMessage());
		}
		System.out.println("GOOD");
	}
}
