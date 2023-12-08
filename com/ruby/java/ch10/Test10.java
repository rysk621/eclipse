package com.ruby.java.ch10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Test10 {
	public static void main(String[] args) {
		lotto_generator(5);
	}

	private static void lotto_generator(int n) {
		Random number = new Random(); //seed 값이 동일하면 random 값 동일하게 나옴.
		HashSet<Integer> lotto = null;
		for (int i = 0; i < n; i++) {
			lotto = new HashSet<>();

			for (int j = 0; lotto.size() <= 6;) { //lotto HashSet의 size가 6이 되면 stop. (;lotto.size()<=6;) 후 j++; 지워도 call 가능. same as while(lotto.size()<=0){lotto.add(number.nextInt(1,46));}
				lotto.add(number.nextInt(45) + 1); //lotto.add(number.nextInt(1,46))도 동일. 1부터 bound 46까지(46은 포함되지 않는다.) //HashSet lotto에 parameter를 add하는 method.
				j++;
			}

			List<Integer> L = new ArrayList<>(lotto); //Integer type의 elements 저장하는 List L에 lotto elements로 초기화하는 ArrayList 생성 
			Collections.sort(L); //List elements를 ㄴ오름차순 정렬
			System.out.println(L);
		}

	}

}
