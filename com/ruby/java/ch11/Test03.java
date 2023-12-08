package com.ruby.java.ch11;

public class Test03 {

	public void d() {
		throw new IndexOutOfBoundsException("오류"); //의도적으로 예외를 발생시키는 throw 문. 여기서는 바로 return시키기 때문에 아래에 코드를 만들면 unreachable code가 되어서 오류 발생.
	}
	
	public void c() throws Exception {
		System.out.println("C1");
//		int v = 10 / 0;
		d();
		System.out.println("C2");
	}
	public void b() throws Exception {
		System.out.println("B1");
		c();
		System.out.println("B2");
	}
	public void a() {
		System.out.println("A1");
		try {	//try-catch문 붙는 곳 변경하며 확인하기. throws 어디에 있어야 하는지 확인.
			b();
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("발생한 오류 : "+e.getMessage());
		}
		System.out.println("A2"); //C2, B2는 출력하지 않음. A2는 try-catch문 밖에 있으므로 출력.
	}

	public static void main(String[] args) throws InterruptedException {

		Test03 t = new Test03();
		t.a(); //an instance method is able to call only after creating an instance.
		
		Thread.sleep(1000); // throws InterruptedException: main method에서는 실행가능
		System.out.println("Fine.");

	}
}
