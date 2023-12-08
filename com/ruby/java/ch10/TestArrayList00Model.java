package com.ruby.java.ch10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestArrayList00Model {
	public static void main(String[] args) {
		// 정수형 값을 담는 리스트 참조변수 생성
		List<Integer> list = new ArrayList<>(); // 작성 후 import
		// 100개의 정수를 랜덤으로 저장
		Random rd = new Random(); // 작성 후 랜덤 객체 import
		// 리스트에 100개의 정수 랜덤으로 저장
		for (int i = 0; i < 100; i++) {
			list.add(rd.nextInt(0, 101));
		}

		// 100개의 정수값을 읽어 최대, 최소, 평균, 합을 구하기
		int min = Integer.MAX_VALUE; // int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE; // int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 1; i < list.size(); i++) {
			int t = list.get(i);
			max = (max < t) ? t : max; // if (max<list.get(i)){max = list.get(i);}
			if (min > t)
				min = t;
			sum += t;
		}
		double avg = (double) sum / list.size();

		System.out.println("합 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.println("최대 : " + max);
		System.out.println("최소 : " + min);

		System.out.println(list);
	}
}
