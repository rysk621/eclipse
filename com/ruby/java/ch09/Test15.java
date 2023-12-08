package com.ruby.java.ch09;

import java.util.Random;

public class Test15 {
	public static void main(String[] args) {
		int[] data = new int[5]; //array 생성
		Random r1 = new Random();
		for (int i = 0; i < 5; i++) {
			data[i] = r1.nextInt(10);
//			System.out.print(i+" : "+r1.nextInt()+"\t");
//			System.out.print(r1.nextInt(10)+"\t");
//			System.out.print(r1.nextBoolean()+"\t");
//			System.out.print(r1.nextDouble()+"\t");
			System.out.println(data[i]);
		}
	}
}
