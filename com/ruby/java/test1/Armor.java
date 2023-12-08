package com.ruby.java.test1;

public class Armor { //만들어진 Armor 객체 --> 첫 번째 필드의 주소를 Exam01의 new 객체생성자의 변수(arm)에 넣어준다.
	private String name;
	public int height;
	private int speed;
	private String color;
	private boolean isFly;
	public void test(int... v) { //v는 배열. int x : v --> x는 v의 원소를 확인.
		System.out.println("test(int... v) 호출");
		for (int x : v) {//x가 array v안에 있으면 --> 매우 많이 사용하므로 알아두기.
			System.out.println(" "+x);
		}
	}
	/*
	public void test(int a) {
		System.out.println("test(int a) 호출");
	}
	public void test(int a, int b) {
		System.out.println("test(int a, int b) 호출");
	}
	public void test(int a, int b, int c) {
		System.out.println("test(int a, int b, int c) 호출");
	}
	*/
	public void show() {
		System.out.println(speed);//정수
		System.out.println(name);//문자열. arm.name은 선언되지 않아서 사용할 수 없음. name은 4행에 private으로 선언되어 있음. (show method 통해 접근제어자 관계 없이 접근 가능)
		System.out.println(height);//정수
	}
	public void speedUp(int value) {
		System.out.println("정수 스피드 증가");
		speed += value;
	}
	public void speedUp(double value) {
		System.out.println("실수 스피드 증가");
		speed += (int)value;
	}
	public int getSpeed() {
		return speed;
	}
	public void setName(int num) {
		String value = "홍길동";
		name = value;
		setHeight(num);//setHeight를 private으로 변경했어도 public인 setName 함수 통해 setHeight에 접근할 수 있다.
	}
	public void setName() {//함수 이름 같을 때 구분: parameter가 다르면 다른 함수 취급 --> method overloading의 정의. 함수 이름 변경보다 매개변수 선언하는 게 나음(함수 종류 많아지지 않는 것이 낫다)
		String value = "홍길동";
		name = value;
	}

	public void setHeight(int value) {//private으로 변경시 Exam01 클래스에서 접근할 수 없음(다른 패키지)
		if (value > 0)
			height = value;
		else {
			System.out.println("음수는 안됩니다.");
		}
	}
	public int takeOff() {
		System.out.println("비행하다");//method 본문
		System.out.println("아이언맨");
		return 0;//sysout 라인 끝나기 전에 return 넣으면 아래 코드는 unreachable code가 되어 죽음.
	}

}
