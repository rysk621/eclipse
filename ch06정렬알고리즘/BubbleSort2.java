package ch06정렬알고리즘;

import java.util.Random;
import java.util.Scanner;

public class BubbleSort2 {
	public static void main(String[] args) {
		System.out.print("input element size: ");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		int[] arr = new int[input];
		scan.close();
		Random rnd = new Random();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			arr[i] = rnd.nextInt(1000);
		}

		System.out.println("raw array: ");
		for(int i : arr) {
			if (i == arr[n-1]) System.out.print(i);
			else System.out.print(i+" ");
		}
		bubbleSort(arr, n);
		System.out.println("\nsorted array: ");
		for(int i : arr) {
			if (i == arr[n-1]) System.out.print(i);
			else System.out.print(i+" ");
		}
	}

	private static void bubbleSort(int[] arr, int n) {
		int count = 0;
		for (int i = 0; i < n-1; i++) {
			int exch = 0;
			for (int j = n-1; j > i ; j--) {
				if (arr[j-1] > arr[j]) swap(arr, j-1, j);
				count++;
				exch++;
			}
			if (exch == 0) break;
		}
		System.out.println("\ncount = "+count);
	}

	private static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
}
