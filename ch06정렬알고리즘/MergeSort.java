package ch06정렬알고리즘;

public class MergeSort {
	static int[] buff;
	
	public static void main(String[] args) {
		// 요소수 15로 고정
		int nx = 15;
		int[] x = {7,6,5,3,7,1,8,9,11,16,21,2,4,15,13}; // new int[nx];
		
//		for (int i = 0; i < nx; i++) {
//			if (i == nx-1) System.out.print("x[" + i + "] = " + x[i] + "\n");
//			else System.out.print("x[" + i + "] = " + x[i] + ", ");
//		}
		System.out.println("=".repeat(10)+" 배열 x, in raw data "+"=".repeat(10));
		printData(x);
		
		mergeSort(x, nx);
		System.out.println();
		System.out.println("=".repeat(10)+" 배열 x, in ascending order "+"=".repeat(10));
		printData(x);
	}

	private static void printData(int[] x) {
		for (int i : x) {
			if (i == x[x.length-1]) System.out.println(i);
			else System.out.print(i+", ");
		}
	}

	private static void mergeSort(int[] x, int nx) {
		buff = new int[nx];
		
		__mergeSort(x, 0, nx - 1);
		
		buff = null;
	}

	private static void __mergeSort(int[] x, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			
			__mergeSort(x, left, center);
			__mergeSort(x, center + 1, right);
			
			merge(x, left, right, center);
		}
	}

	private static void merge(int[] x, int left, int right, int center) {
		int i;
		int p = 0;
		int j = 0;
		int k = left;
//		buff[0]에서부터 buff[center-left]에 x[left]부터 x[center] 값을 저장
		for (i = left; i <= center; i++) {
			buff[p++] = x[i];
		}
//		i(center+1)에서 x[right](x 배열의 center index 뒤쪽 절반), j(0)에서 p(center-left+1) 사이일 때: buff[j] <= x[i] 비교, 둘 중 작거나 같은 값을 x[left++]에 저장   
		while (i <= right && j < p) {
			x[k++] = (buff[j] <= x[i]) ? buff[j++] : x[i++];
		}
//		i가 right보다 클 경우(배열 x에 buff와 비교할 수 있는 요소 남지 않았을 경우) x[k++]에는 buff[j++]를 저장 (x[right]까지 저장했고 buff 배열에는 요소가 남아있음.)
		while (j < p) x[k++] = buff[j++];
	}
}
