package ch03검색알고리즘;

import java.util.Arrays;
import java.util.Random;

public class IntArrayBinarySearch {
	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data);
		showData(data);
		sortData(data);
		System.out.println();
		System.out.println("Sorted int[] data");
		for (int num: data) {
			System.out.print(num+" ");
		}
		System.out.println("\nLinear Search");
		int key = 33;
		int result = linearSearch(data, key);
		if (result == -1) System.out.println("결과가 없습니다.");
		else System.out.println("linearSearch(): result = " + result);

		key = 39;
		result = binarySearch(data, key);
		System.out.println("\nBinary Search");
		if (result == -1) System.out.println("결과가 없습니다.");
		else System.out.println("binarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		if (result == -1) System.out.println("결과가 없습니다.");
		else System.out.println("Arrays.binarySearch(): result = " + idx);
		}

	static int[] inputData(int[] data) {
		// 난수 생성 입력
		Random rand = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(50) + 1;
		}
		return data;
	}
	
	static void showData(int[] data) {
		System.out.println("int[] data");
		for (int i : data) {
			System.out.print(i+" ");
		}
	}
	
	static void sortData(int[] data) {
		Arrays.sort(data);
	}
	
	static int linearSearch(int[] data, int key) {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == key) return i;
		}
		return -1;
	}
	
	static int binarySearch(int[] data, int key) {
		int start = 0;
		int end = data.length - 1;
		do {
			int mid = (start + end)/2;
			if (data[mid] == key) return mid;
			else if(data[mid] < key) start = mid + 1;
			else end = mid - 1;
		}while(start <= end);
		return -1;
	}
}
