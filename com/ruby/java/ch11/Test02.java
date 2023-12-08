package com.ruby.java.ch11;

public class Test02 {

	public void c() throws Exception {
		System.out.println("C1");
		int v = 10 / 0;
		System.out.println("C2");
	}
	public void b() throws Exception {
		System.out.println("B1");
		c();
		System.out.println("B2");
	}
	public void a() {
		System.out.println("A1");
		try {
			b();
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("발생한 오류 : "+e.getMessage());
			//e.getMessage();만 두면 아무것도 출력되지 않음
		}
		System.out.println("A2"); //C2, B2는 출력하지 않음. A2는 try-catch문 밖에 있으므로 출력.
	}

	public static void main(String[] args) {

		Test02 t = new Test02();
		t.a(); //an instance method is able to call only after creating an instance.
		
		try {
			Thread.sleep(1000); //exception 처리 어떻게 할 것인지 2가지 선택지 offer, surround 선택. what if throws exception?
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fine.");

		System.out.println("\n" + "=".repeat(20)+"\n");
		try {
			System.out.println("1");
			String s = null;
			s.length();
			System.out.println("2");
			System.out.println("3");
		} catch (Exception e) {
			System.out.println("오류 발생");
		} finally {
			System.out.println("OK");
		}
		System.out.println("4");
	}
}
