package com.ruby.java.ch09;

public class Test12 {
	public static void main(String[] args) {
		int n1 = 10;
		Integer obj1 = n1; //Integer.valueOf(n1)
		
		Integer obj2 = Integer.valueOf("20");
		System.out.println(obj2+20);
		int n2 = obj2;
		
		Integer obj3 = 30;
		
		int n3 = obj3 + 40;
		
		System.out.println(n1+" : "+obj1);
		System.out.println(obj2+" : "+n2);
		System.out.println(n3);
		
		int i3 = Integer.parseInt("123");
		String s1 = "9";
		String s2 = "21";
		int i1 = Integer.parseInt(s1); //String to integer type으로 변환 (type casting과 차이)
		int i2 = Integer.parseInt(s2);

		if(i1<i2) {
			System.out.println(s1+" < "+s2+" is true");
		}else {
			System.out.println(s1+" < "+s2+" is false");
		}
	}
}
