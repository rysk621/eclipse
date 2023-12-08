package ch02기본자료구조;

public class 스트링배열정렬 {
	public static void main(String[] args) {
		String[] data = { "apple", "grape", "persimmon", "pear", "blueberry", "strawberry", "melon", "oriental melon" };

		System.out.println("String[] data");
		showData(data);
		sortData(data);
		System.out.println("\n"+"정렬된 String[] data(사전순)");
		showData(data);
		sortDataDesc(data);
		System.out.println("\n"+"정렬된 String[] data(역순)");
		showData(data);
	}

	static void showData(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	static void swap(String[] arr, int ind1, int ind2) {
		String temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}

	static void sortData(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i].compareTo(arr[j])>0) {
					swap(arr, i, j);
				}
			}
		}
	}
	
	static void sortDataDesc(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i].compareTo(arr[j])<0) {
					swap(arr, i, j);
				}
			}
		}
	}
}
