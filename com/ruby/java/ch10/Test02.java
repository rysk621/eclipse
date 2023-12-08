package com.ruby.java.ch10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test02 {
	public static void main(String[] args) {
		List<String> list = new ArrayList();
		list.add("서울"); list.add("북경"); list.add("상해");   //순서 있으므로 중복 가능
		list.add("서울"); list.add("도쿄"); list.add("뉴욕");
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i)); //index get(i)의 elements를 출력합니다.
		}
		
		System.out.println("=".repeat(10));
		
		Iterator<String> iter = list.iterator(); //String type의 iterator 생성, list.iterator method
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
