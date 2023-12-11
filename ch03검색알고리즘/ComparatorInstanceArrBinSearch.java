package ch03검색알고리즘;

import java.util.Arrays;
import java.util.Comparator;

//3장 객체 배열 정렬 - binary search
/*
* Comparator를 사용하는 방법
* MyComparator implements Comparator<>
* MyComparator myComparator = new MyComparator();
* Arrays.sort(array, myComparator);
* Collections.sort(list, myComparator);
*/
class Fruit3 {
	String name;
	int price;
	String expire;

	public Fruit3(String name, int price, String expire) {
		this.name = name;
		this.price = price;
		this.expire = expire;
	}

	@Override
	public String toString() {
		return "<" + name + ", " + price + ", " + expire + ">";
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
	
	public String getExpire() {
		return expire;
	}
}

class FruitNameComparator implements Comparator<Fruit3> {
	public int compare(Fruit3 f1, Fruit3 f2) {
		int result = f1.name.compareTo(f2.name);
		if (result == 0) {
			result = f1.price - f2.price;
			if (result == 0) {
				result = f1.expire.compareTo(f2.expire);
			}
		}
		return result;
		}
}

class FruitPriceComparator implements Comparator<Fruit3> {
	public int compare(Fruit3 f1, Fruit3 f2) {
		int result = f1.price - f2.price;
		if (result == 0) {
			result = f1.name.compareTo(f2.name);
			if (result == 0) {
				result = f1.expire.compareTo(f2.expire);
			}
		}
		return result;
	}
}

public class ComparatorInstanceArrBinSearch {
	private static void sortData(Fruit3[] arr, Comparator<Fruit3> cc_price) {
//		Comparator<Fruit3> cc_price를 이용하여 sort
		for (int i=0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (cc_price.compare(arr[i], arr[j])>0)
					swap(arr, i, j);
			}
		}
		
	}

	static void swap(Fruit3[] arr, int ind1, int ind2) {
		Fruit3 temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}

	static void sortData(Fruit3[] arr, FruitNameComparator cc) {
		for (int i=0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (cc.compare(arr[i], arr[j])>0)
					swap(arr, i, j);
			}
		}
	}

	static void showData(Fruit3[] arr) {
		for (Fruit3 fx: arr) {
			System.out.print(fx+" "); //toString() method overriding 되어있음.
		}
		System.out.println();
	}

	// 교재 111 페이지 참조하여 구현
	static int binarySearch(Fruit3[] arr, Fruit3 f, Comparator<Fruit3> cc) {
		int result = 0;
		int start = 0;
		int end = arr.length;
		while (start <= end) {
			int mid = (start + end)/2;
			if (cc.compare(arr[mid], f) == 0) return mid;
			else if (cc.compare(arr[mid], f)>0) end = mid - 1;
			else start = mid + 1;
		}
		return result;
	}

	public static void main(String[] args) {

		Fruit3[] arr = {new Fruit3("사과", 200, "2023-5-8"), 
				new Fruit3("키위", 500, "2023-6-8"),
				new Fruit3("오렌지", 200, "2023-7-8"), 
				new Fruit3("바나나", 50, "2023-5-18"), 
				new Fruit3("수박", 880, "2023-5-28"),
				new Fruit3("체리", 10, "2023-9-8") };
		
		System.out.println("정렬전 객체 배열: ");
		showData(arr);
		FruitNameComparator cc = new FruitNameComparator();
//		Arrays.sort(arr, cc);
		sortData(arr, cc);
		System.out.println("\nFruitNameComparator 사용하여 이름순 정렬 후 객체 배열: ");
		showData(arr);
	
		Arrays.sort(arr, (a, b) -> a.getPrice() - b.getPrice()); // Fruit3에 compareTo()가 있어도 람다식 우선 적용
		System.out.println("\n람다식 정렬(가격)후 객체 배열: ");
		showData(arr);
		
//		comparator<Fruit3>객체의 compare() method overriding하여 정렬(이름순)
		Arrays.sort(arr, new Comparator<Fruit3>() {
			@Override
			public int compare(Fruit3 a1, Fruit3 a2) {
				return a1.getName().compareTo(a2.getName());
			}
		});
		System.out.println("\ncomparator 정렬(이름)후 객체 배열: ");
		showData(arr);
		
		Comparator<Fruit3> cc_name = new Comparator<Fruit3>() { // 익명클래스 사용
			public int compare(Fruit3 a1, Fruit3 a2) {
				return a1.getName().compareTo(a2.getName());
			}
		};
		
		Comparator<Fruit3> cc_price = new Comparator<Fruit3>() {
			public int compare(Fruit3 a1, Fruit3 a2) {
				return a1.getPrice() - a2.getPrice();
			}
		};

		Fruit3 newFruit3 = new Fruit3("체리", 500, "2023-5-18");
		int result3 = Arrays.binarySearch(arr, newFruit3, cc_name);
		System.out.println("\nArrays.binarySearch() 조회결과::" + result3); //이름순 정렬시 이름이 체리인 element는 arr[4]이므로 이진탐색 result3 = 4이다.
		result3 = binarySearch(arr, newFruit3, cc_name);
		System.out.println("binarySearch() 조회결과::" + result3); 

		sortData(arr, cc_price);
		System.out.println("\ncomparator 정렬(가격)후 객체 배열: ");
		showData(arr);
		result3 = Arrays.binarySearch(arr, newFruit3, cc_price);
		System.out.println("\nArrays.binarySearch() 조회결과::" + result3); //가격순 정렬시 가격이 500인 element는 arr[4]이므로 result3 = 4이다.
		result3 = binarySearch(arr, newFruit3, cc_price);
		System.out.println("binarySearch() 조회결과::" + result3);
	}
}
