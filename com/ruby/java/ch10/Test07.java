package com.ruby.java.ch10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test07 {
	public static void main(String[] args) {
		
		HashMap<String, String> dic = new HashMap<>();
		
		dic.put("고진감래", "고생 끝에 즐거움이 옴");
		dic.put("분골쇄신", "몸이 부서질 정도로 노력을 다함");
		dic.put("권토중래", "실패를 발판삼아 재기함");
		dic.put("교학상자", "가르치고 배우면서 서로 성장함");
		dic.put(null, null);
		
		// 저장된 데이터에 접근하는 방법 3가지 1) using iterator, 2) Map.Entry<> 생성 --> entry의 element가 dic.entrySet() 이내에 있는지 확인하여 출력, 3) key가 dic.keySet() 이내에 있는지 확인하여 출력
		// 1) using iterator
		Iterator<String> keys = dic.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			System.out.println(String.format("%s : %s", key, dic.get(key)));
		}
		System.out.println();
		
		// 2) Map.Entry<> elem 생성, dic.entrySet()과 비교
		for(Map.Entry<String, String> elem : dic.entrySet()) {
			System.out.println(String.format("%s : %s", elem.getKey(), elem.getValue()));
		}
		System.out.println();
		
		// 3) String key를 dic.keySet()과 비교
		for(String key : dic.keySet()) {
			System.out.println(String.format("%s : %s", key, dic.get(key)));
		}
	}
}
