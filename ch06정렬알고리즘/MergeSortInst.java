package ch06정렬알고리즘;

class PhyscData {
	String name;
	int height;
	double vision;

	public PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	public int compareTo(PhyscData o) {
		int result = this.name.compareTo(o.name);
		if (result == 0) {
			result = this.height - o.height;
			if (result == 0) {
//				vision은 double이므로 0.0 != 0.1 비교가능, int는 0.1과 0.0 비교불가능
				double d = this.vision - o.vision;
				if (d == 0.0) return 0;
				else if (d < 0.0) return -1;
				else return 1;
			}
		}
		return result;
	}
}

public class MergeSortInst {
	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void merge(PhyscData[] a, int left, int right, int center) {
		int i;
		int n = 0;
		int m = 0;
		int k = left;
		PhyscData[] list = new PhyscData[a.length];
		for (i = left; i <= center; i++) {
			list[n++] = a[i];
		}
		while (i <= right && m < n) {
			a[k++] = (list[m].compareTo(a[i]) <= 0) ? list[m++] : a[i++];
		}
		while (m < n)
			a[k++] = list[m++];
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void mergeSort(PhyscData[] a, int left, int right) {
		int mid = (left + right) / 2;
		if (left == right)
			return;
		mergeSort(a, left, mid);
		mergeSort(a, mid + 1, right);
		merge(a, left, right, mid);
		return;
	}

	public static void main(String[] args) {
		PhyscData[] x = { new PhyscData("이민하", 162, 0.3), new PhyscData("이민하", 150, 0.3), new PhyscData("이민하", 160, 0.7),
				new PhyscData("김찬우", 173, 0.7), new PhyscData("김찬우", 168, 0.7), new PhyscData("김찬우", 173, 0.5),
				new PhyscData("박준서", 171, 2.0), new PhyscData("유서범", 171, 1.5), new PhyscData("이수연", 168, 0.4),
				new PhyscData("장경오", 171, 1.2), new PhyscData("황지안", 169, 0.8), };
		int nx = x.length;

		mergeSort(x, 0, nx - 1); // 배열 x를 정렬
		System.out.println("오름차순으로 정렬했습니다.");
		System.out.println("■ 신체검사 리스트 ■");
		System.out.println("이름\t키\t시력");
		System.out.println("--------------------");
		for (int i = 0; i < x.length; i++)
			System.out.printf("%s\t%3d\t%.1f\n", x[i].name, x[i].height, x[i].vision);
	}
}
