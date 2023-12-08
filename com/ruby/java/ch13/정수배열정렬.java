package com.ruby.java.ch13;

import java.util.Arrays;
import java.util.Random;

public class 정수배열정렬 {
	public static void main(String[] args) {
		int[] data = new int[20];
		Random rnd = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = rnd.nextInt(50)+1;
		}
		Arrays.sort(data);
		System.out.println(Arrays.toString(data));// 출력
		
//		int[] data2 = new int[10];
//		Random rnd2 = new Random();
//		for (int i = 0; i < data2.length; i++) {
//			data2[i] = rnd2.nextInt(20)+1;
//		}
//		Arrays.sort(data2);
//		System.out.println(Arrays.toString(data2));
	}
}
