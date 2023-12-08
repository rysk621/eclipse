package ch03검색알고리즘;

import java.util.Arrays;

//3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
//comparator 구현 실습
public class StringArrayBinarySearch {
	public static void main(String[] args) {
		String []data = {"apple", "grape", "persimmon", "감", "배", "사과", "포도", "pear", "blueberry", "strawberry", "melon", "oriental melon"};

		System.out.println("<String[] data>");
		showData(data);
		sortData(data);
		System.out.println("\n<Sorted data>");
		showData(data);

		System.out.println("\nString key = \"감\"");
		String key = "감";
		int result = linearSearch(data, key);
		if (result == -1) System.out.println("값이 없습니다.");
		else System.out.println("linearSearch(): result = " + result);

		System.out.println("\nString key = \"배\"");
		key = "배";
		result = binarySearch(data, key);
		System.out.println("binarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("Arrays.binarySearch(): result = " + idx);
	}
	
	static void showData(String[] data) {
		for (String i : data) {
			if (i == data[data.length-1]) System.out.print(i+"\n");
			else System.out.print(i+", ");
		}
	}
	
	static void sortData(String[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = i+1; j < data.length; j++) {
				if (data[i].compareTo(data[j]) > 0) {
					swap(data, i, j);
				}
			}
		}
	}
	
	static void swap(String[] data, int i, int j) {
		String temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	static int linearSearch(String[] data, String key) {
		for (int i=0; i<data.length; i++) {
			if (data[i] == key) return i;
		}
		return -1;
	}
	
	static int binarySearch(String[] data, String key) {
		int start = 0;
		int end = data.length;
		
		while(start <= end) {
			int mid = (start + end)/2;
			if (data[mid] == key) return mid;
			else if (data[mid].compareTo(key) < 0) start = mid + 1;
			else end = mid - 1;
		}
		return -1;
	}
}
