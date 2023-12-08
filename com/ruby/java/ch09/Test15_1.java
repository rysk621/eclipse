package com.ruby.java.ch09;

import java.util.Arrays;
import java.util.Random;

public class Test15_1 {
	public static void main(String[] args) {
		int data[]	= new int[10];
		Random r2 = new Random();
		for(int i = 0;i<10;i++) {
			data[i] = r2.nextInt(10); //r2의 nextInt method 호출
		}
		for (int num: data)
			System.out.print(num + "  ");
			System.out.println();
		Arrays.sort(data);
		for (int num: data) //data array에 있는 int num에 대하여
			System.out.print("  " + num);
			System.out.println();
		System.out.println(Arrays.toString(data)); //data array를 list화 해서 출력해줌.
	}
}
// 정규표현식: id or password 등의 expression이 특정한 조건을 만족해야 함 --> Test18