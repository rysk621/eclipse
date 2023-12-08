package com.ruby.java.ch10;

import java.util.HashMap;
import java.util.Set;

public class Test06 {
	public static void main(String[] args) {

		String word[] = { "BUMBLEBEE", "HEAVEN", "ALTHOUGH", "WONDER" };
		String meaning[] = { "꿀벌과에 속하는 호박벌", "천국", "그럼에도 불구하고", "호기심이 들다" };

		HashMap<String, String> dic = new HashMap<>();

		for (int i = 0; i < word.length; i++) {
			dic.put(word[i], meaning[i]);
		}

		System.out.println(dic);
		System.out.println(dic.size());
		System.out.println();

		System.out.println(dic.keySet());
		System.out.println("=".repeat(20));
		Set<String> keys = dic.keySet();
		for (String key : keys) {
			System.out.println("\t" + key + " : " + dic.keySet());
		}
		System.out.println("=".repeat(20));

		System.out.println(dic.values());
		System.out.println();

		System.out.println("HEAVEN : " + dic.get("HEAVEN"));
		dic.replace("HEAVEN", "아주 행복한 감정");
		System.out.println("HEAVEN : " + dic.get("HEAVEN"));
		dic.put("HEAVEN", "이상적인 세상");
		System.out.println("HEAVEN : " + dic.get("HEAVEN"));
		System.out.println(dic);

		System.out.println(dic.containsKey("BUMBLEBEE"));
		System.out.println(dic.containsValue("자장가") + "\n");

		dic.remove("HEAVEN"); // dic instance의 remove method call --> argument "HEAVEN" in parameter -->
								// remove method 실행, parameter 제거
		System.out.println(dic.containsKey("HEAVEN")); // dic contains Key(String)? --> return boolean type result

		dic.clear();
		System.out.println(dic.isEmpty());
		System.out.println(dic.size());
	}
}
