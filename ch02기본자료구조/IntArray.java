package ch02기본자료구조;

import java.util.Random;
import java.util.Scanner;

public class IntArray {
	@SuppressWarnings("unused")
	private static int maxOf(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}
	static void swap(int[] a, int i,int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	private static void sortAsc(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) { //j = i + 1로 설정해야 쓸데없는 loop가 없다.
				if (a[i] > a[j]) {
					swap(a, i, j);
				}
			}
		}
	}
	
	private static void sortDesc(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if (a[i] < a[j]) {
					swap(a, i, j);
				}
			}
		}
	}

	public static void main(String[] args) {
		Random rand = new Random();
		System.out.print("배열 수: ");
		Scanner stdIn = new Scanner(System.in);
		int num = stdIn.nextInt();

		int[] a = new int[num]; // C language에서는 안됨.
		for (int i = 0; i < num; i++) {
			a[i] = rand.nextInt(100);
		}
		for (int n : a) {
			System.out.print(n + " ");
		}
		System.out.println();

		sortAsc(a); // sort method 만들기
//		System.out.print("sorted int[] a (in ascending order) = ");
		for (int n : a) {
			System.out.print(n + " ");
		}
		System.out.println();
		sortDesc(a); // sort method 만들기
		System.out.print("sorted int[] a (in descending order) = ");
		for (int n : a) {
			System.out.print(n + " ");
		}

//		int[] b = { 11, 25, 3, 14, 5 };
//		int result = maxOf(b);
//		System.out.println("max = "+result);

//		a[1] = 37;
//		a[2] = 41;
//		a[4] = a[1] * 2;
//
//		for (int i = 0; i < a.length; i++) {
//			System.out.println("a[" + i + "]" + " = " + a[i]);
//		}
		stdIn.close();
	}

}
