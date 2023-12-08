package com.ruby.java.test2;

import com.ruby.java.test1.*; // 클래스 이름 대신 * 입력하면 패키지 안의 모든 파일 import 함.

public class Exam01 {
	public static void main(String[] args) {
		Armor arm = new Armor(); // 타입 변수 = 객체생성자 ; Armor 객체의 주소를 변수가 가지고 있음.
		arm.height = 99; // public 접근제한자를 사용하고 있으므로 다른 패키지인 해당 클래스에서도 접근 및 변경 가능.
		//arm.setHeight(100); // setHeight 변수를 입력 --> int value를 입력한 것이므로 height값이 변경됨 (Armor의 method에서 변경되는 것)
		arm.takeOff();
		int result = arm.takeOff();
		System.out.println("result = "+result);
		arm.speedUp(100);
		int speed = arm.getSpeed();
		System.out.println("speed = "+speed);
		//System.out.println(height);
		System.out.println(arm.height);
		arm.show();
		arm.speedUp(99.9999);
		arm.test();
		arm.test(1,2,3);
	}
}
