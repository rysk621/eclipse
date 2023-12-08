package ch02기본자료구조;

class PhyscData2 implements Comparable<PhyscData2> {
	String name;
	int height;
	double vision;

	public PhyscData2(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	@Override
	public int compareTo(PhyscData2 o) {
		int result = this.name.compareTo(o.name);
		if (result == 0) {
			result = this.height - o.height;
			if (result == 0) {
				double d = this.vision - o.vision;
				if (d == 0.0) return 0; //double이므로 0.0과 비교할 것
				else if (d > 0.0) return 1;
				else return -1;
			}
		}
		return result;
	}
}

public class 객체배열정렬 {
	public static void main(String[] args) {
		PhyscData2[] data = { new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("홍길동", 162, 1.3),
				new PhyscData2("홍길동", 152, 0.7),
				new PhyscData2("김홍길동", 172, 0.3),
				new PhyscData2("이길동", 182, 0.6),
				new PhyscData2("박길동", 167, 0.2),
				new PhyscData2("최길동", 169, 0.5), };
		System.out.println("raw data");
		showData(data);
		System.out.println("\nsorted data");
		sortData(data);
		showData(data);
	}

	private static void sortData(PhyscData2[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i].compareTo(data[j]) > 0) {
					swap(data, i, j);
				}
			}
		}
	}
	
	private static void swap(PhyscData2[] data, int i, int j) {
		PhyscData2 temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	private static void showData(PhyscData2[] data) {
		for (int i = 0; i<data.length; i++) {
			System.out.print(data[i].name+", ");
		}
	}
}
