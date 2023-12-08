package edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

//	24개의 원소를 갖는 정수형 1차원 배열 선언, 랜덤 값 입력
//	1. 입력된 배열 array 출력
//	2. array를 오름차순으로 정렬 후 출력
//	3. 배열을 3by4 A1 행렬과 3by4 B1 행렬로 만들어서 행렬 합을 구한 뒤 출력
//	4. 배열을 3by4 A2 행렬과 4by3 B2 행렬로 만들어서 행렬 곱을 구한 뒤 출력
//	5. 배열을 4by3 A3 행렬과 3by4 B3 행렬로 만들어서 행렬 곱을 구한 뒤 출력

public class Matrix2 {
	class Matrix{
		
	}
	
	public static void main(String[] args) {
		ArrayList array = new ArrayList(24);
		Random rand = new Random();
		for (int n = 0; n<array.size(); n++) {
			n = rand.nextInt(101);
			array.add(n);
		}
	}
}
