package com.ruby.java.ch10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestArrayList00{

	public static void main(String[] args) {
		// 0~100까지의 정수를 랜덤하게 생성 --> 생성한 수를 list에 저장 
		// --> 100개의 정수값을 최대, 최소, 평균, 합을 구함 (따로 생성할 것; 가독성)
		// --> 구한 값을 출력
		List<Integer> list = new ArrayList();
		Random rd = new Random();
		int min = Integer.MAX_VALUE; 
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < 100; i++) { //100회 반복, i=0으로 초기화 및 i<100 조건
			int rn = rd.nextInt(0, 101); //bound 결정하기; 100 까지의 수를 생성하려면 101 insert.
			list.add(rn);
			sum += rn;
			if (min>list.get(i)) min = list.get(i); //i번째 index 호출: list.get(i)
			if (max<list.get(i)) max = list.get(i);
		}
		double avg = (double) sum / list.size();
		System.out.println(list + ",\nlist size : " + list.size());
		System.out.println("sum: " + sum + ", average: " + avg);
		System.out.println("min: " + min + ", max: " + max);
	}
}
