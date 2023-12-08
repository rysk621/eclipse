package com.ruby.java.ch10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test01 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>(); //List<String> list = new ArrayList();로 작성 가능
		list.add("서울"); list.add("북경"); list.add("상해");   //순서 있으므로 중복 가능
		list.add("서울"); list.add("도쿄"); list.add("뉴욕");
		
		for (int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}
		
//		list.forEach(s->System.out.println("forEach: "+s)); //Ch 14. lambda function
		
		list.add("런던"); list.add("로마"); list.add("방콕");
		list.add("북경"); list.add("도쿄"); list.add("서울");
		System.out.println("1 : " + list.toString());
		
		list.add(1, "LA"); print(2, list); //index 1에 "LA" insert, print method 생성 및 실행
		
		System.out.println("3 : " + list.indexOf("서울")); //result : "3 : 0"; "서울"의 index number, 첫번째는 index 0
		System.out.println("4 : " + list.lastIndexOf("서울")); //result : "4 : 12"; last "서울" element의 index number
		
		list.remove("LA"); print(5, list); //list.remove method 이용하여 "LA" 제거 및 리스트 5로 print
		
		list.remove(2); print(6, list); //list.remove method 이용하여 index 2 제거 및 list 6으로 print
		
		System.out.println("7 : " + list.contains("LA")); //list.contains method 실행; return type은 boolean이므로 결과값은 false
		
		Object obj[] = list.toArray(); //Object obj array에 list.toArray method를 insert. ?? Array method definition
		System.out.println("8 : " + Arrays.toString(obj)); //Arrays.toString method에 obj array 전달하여 method 실행
		
		String cities[] = new String[0]; //String array cities를 생성
		cities = list.toArray(cities); //String cities는 list.toArray(cities)의 elements(type: String)
		System.out.println("9 : " + Arrays.toString(cities)); //Arrays.toString method에 cities array 전달하여 method 실행
		
		list.clear(); print(10, list); //list.clear method로 arraylist를 clear, list 10으로 cleared list 출력
		
		System.out.println("11 : " + list.isEmpty()); //arraylist가 empty입니까? boolean type result 출력. 결과는 true.
		
		list.add("파리");
		list.add("방콕");
		list.add("LA");
		
		List<String> list2 = Arrays.asList("서울","뉴욕","상해"); print(12, list2); //새로운 list인 list2를 생성, Array.asList method에 인자값 직접 전달하여 list 생성합니다.
		
		
	}

	private static void print(int i, List<String> list) {
		System.out.println(i + " : " + list);
	}
}
