package ch03검색알고리즘;

import java.util.Arrays;

class PhyscData implements Comparable<PhyscData>{
	String name;
	int height;
	double vision;

	public PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	@Override
	public int compareTo(PhyscData o) {
		int result = this.name.compareTo(o.name);
		if (result == 0) {
			result = this.height - o.height;
			if (result == 0) {
				double d = this.vision - o.vision; //vision은 double이므로 0.0 != 0.1 비교가능, int는 0.1과 0.0 비교불가능
				if (d == 0.0) return 0;
				else if (d < 0.0) return -1;
				else return 1;
			}
		}
		return result;
	}

//	public boolean equals(PhyscData i) {
//		if (this.name == i.name && this.height == i.height && this.vision == i.vision) return true;
//		else return false;
//	}
}

public class InstanceArrayBinarySearch {
	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("길동", 182, 0.6),
				new PhyscData("길동", 167, 0.2),
				new PhyscData("길동", 167, 0.5),
		};
		
		System.out.println("PhyscData[] data");
		showData(data);
		sortData(data);
		System.out.println("Sorted data");
		showData(data);
		
		PhyscData key = new PhyscData("길동", 167, 0.2);
		int result = linearSearch(data, key);
		System.out.println("Linear Search");
		if (result == -1) System.out.println("값이 없습니다.");
		else System.out.println("linearSearch(): result = " + result);
		System.out.println();
		
		key = new PhyscData("길동", 167, 0.5);
		result = binarySearch(data, key);
		System.out.println("Binary Search");
		if (result == -1) System.out.println("값이 없습니다.");
		else System.out.println("binarySearch(): result = " + result);
		
		int idx = Arrays.binarySearch(data, key);
		System.out.println("Arrays.binarySearch(): result = " + idx);
	}
	
	static void showData(PhyscData[] arr) {
		for (PhyscData st: arr) {
			if (st.equals(arr[arr.length-1])) System.out.print(st.name+"\n");
			else System.out.print(st.name+", ");
		}
		System.out.println();
	}
	
	static void sortData(PhyscData[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i].compareTo(data[j])>0) {
					swap(data, i, j);
				}
			}
		}
	}
	
	static void swap(PhyscData[] data, int i, int j) {
		PhyscData temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	static int linearSearch(PhyscData[] data, PhyscData key) {
		for (int i = 0; i < data.length; i++) {
//			compareTo() method 이용하면 됩니다. equals() method 써도 되긴 됨.
			if (data[i].compareTo(key)==0) {
				return i;
			}
		}
		return -1;
	}
	
	static int binarySearch(PhyscData[] data, PhyscData key) {
		int start = 0;
		int end = data.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (data[mid].compareTo(key) == 0) return mid; //이 줄에서 equals() method 사용하면 결과값 다르게 나온다.
			else if (data[mid].compareTo(key) > 0) {
				end = mid - 1;
			}else start = mid + 1;
		}
		return -1;
	}
}
