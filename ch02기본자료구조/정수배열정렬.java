package ch02기본자료구조;

//교재 60 - 실습 2-6
//2번 실습
import java.util.Random;

public class 정수배열정렬 {
	public static void main(String[] args) {
		int[] data = new int[10];
		inputData(data);
		for (int num : data) {
			System.out.print(num + " ");
		}
		/*
		 * sortData(data); System.out.println(); for (int num: data) {
		 * System.out.print(num+" "); }
		 */
		reverse(data);// 역순으로 재배치 - 정렬 아님
		System.out.println();
		for (int num : data) {
			System.out.print(num + " ");
		}
		reverseSort(data);// 역순으로 재배치 - 정렬
		System.out.println();
		for (int num : data) {
			System.out.print(num + " ");
		}
	}

	static void inputData(int[] data) {
		Random rand = new Random();

		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(100);
		}
	}

	static void swap(int[] arr, int ind1, int ind2) {
		int temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}

	static void sortData(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
		}
	}

	static void reverse(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				swap(arr, i, j);
			}
		}
	}

	static void reverseSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					swap(arr, i, j);
				}
			}
		}
	}
}
