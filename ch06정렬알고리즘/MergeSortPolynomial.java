package ch06정렬알고리즘;

class Polynomial implements Comparable<Polynomial>{
    double coef;           // 계수
    int    exp;            // 지수
    
    public Polynomial(double coef, int exp) {
    	this.coef = coef;
    	this.exp = exp;
    }
    
	@Override
	public int compareTo(Polynomial o) {
		int result = this.exp - o.exp;
		if (result == 0) {
			double a = this.coef - o.coef;
			if (a < 0) return -1;
			else if (a == 0) return 0;
			else return 1;
		}
		return result;
	}

	@Override
	public String toString() {
		return "Polynomial [coef = " + coef + ", exp = " + exp + "]";
	}
}

public class MergeSortPolynomial {
	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void merge(Polynomial[] x, int lefta, int righta, int leftb, int rightb ) {
		 //body를 지우고 작성 훈련 연습이 도움이 된다 
		Polynomial[] a = new Polynomial[x.length];
		int i;
		int n = 0;
		int m = 0;
		int k = lefta;
		
		for (i = lefta; i < righta ; i++) {
			a[n++] = x[i];
		}
		
		while (leftb <= rightb && m < n) {
			x[k++] = (a[m].compareTo(x[leftb]) < 0) ? a[m++] : x[leftb++];
		}
		
		while (m < n) {
			x[k++] = a[m++];
		}
	}
	
	static void merge(Polynomial[] x, int left, int right, int center) {
		Polynomial[] a = new Polynomial[x.length];
		int i;
		int n = 0;
		int m = 0;
		int k = left;
		
		for (i = left; i <= center; i++) {
			a[n++] = x[i];
		}
//		i == center+1;
//		while (center+1 <= right && a cursor(m) < a capacity(n, which is center-left+1))
		while (i <= right && m < n) {
//			a(0~center)의 요소와 x(center+1~right)의 요소 비교, 선순위인 요소를 x(0~center)에 넣는다.
			x[k++] = (a[m].compareTo(x[i]) <= 0) ? a[m++] : x[i++];
		}

//		center+1 > right 이면서 a cursor < a capacity 인 경우. x(center+1~x.length)를 a의 요소로 채운다.
		while(m < n) {
			x[k++] = a[m++];
		}
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void MergeSort(Polynomial[] a, int left, int right) {
		int mid = (left+right)/2;
		if (left == right) return;
		MergeSort(a, left, mid);
		MergeSort(a, mid+1, right);
		merge(a, left, right, mid);
		return;
	}

	public static void main(String[] args) {
		Polynomial[] x = {
		         new Polynomial(1.5, 3),
		         new Polynomial(2.5, 7),
		         new Polynomial(3.3, 2),
		         new Polynomial(4.0, 1),
		         new Polynomial(2.2, 0),
		         new Polynomial(3.1, 4),
		         new Polynomial(3.8, 5),
		     };
		Polynomial[] y = {
		         new Polynomial(1.5, 1),
		         new Polynomial(2.5, 2),
		         new Polynomial(3.3, 3),
		         new Polynomial(4.0, 0),
		         new Polynomial(2.2, 4),
		         new Polynomial(3.1, 5),
		         new Polynomial(3.8, 6),
		     };
		int nx = x.length;

		System.out.println("=".repeat(10)+"x, raw array"+"=".repeat(10));
		ShowPolynomial("정렬전 x  = ",x);
		System.out.println("=".repeat(10)+"y, raw array"+"=".repeat(10));
		ShowPolynomial("정렬전 x  = ",y);
		MergeSort(x, 0, x.length - 1); // 배열 x를 정렬
		MergeSort(y, 0, y.length - 1); // 배열 y를 정렬
		System.out.println("=".repeat(10)+"x, mergeSorted array"+"=".repeat(10));
		ShowPolynomial("다항식 x =", x);
		System.out.println("=".repeat(10)+"y, mergeSorted array"+"=".repeat(10));
		ShowPolynomial("다항식 y= ", y);
		Polynomial[] z = new Polynomial[20];
		AddPolynomial(x,y,z); // 다항식 덧셈 z = x + y
		ShowPolynomial("다항식 z = x + y", z);
//		MultiplyPolynomial(x,y,z); // 다항식 곱셈 z = x * y
//		ShowPolynomial(y);
//		int result = EvaluatePolynomial(z, 10); // 다항식 값 계산 함수 z(10) 값 계산한다 
//		System.out.println(" result = " + result );
	}

	private static void AddPolynomial(Polynomial[] x, Polynomial[] y, Polynomial[] z) {
		int px = 0, py = 0, pz = 0;
		while (px < x.length && py < y.length) {
			if (x[px].exp == y[py].exp) {
				double tmp = x[px].coef + y[py].coef;
				z[pz++] = x[px++];
				z[pz].coef = tmp;
				py++;
			} else if (x[px].exp < y[py].exp) {
				z[pz++] = x[px++];
			} else {
				z[pz++] = y[py++];
			}
		}
	}

	private static void ShowPolynomial(String str, Polynomial[] x) {
		System.out.println("\n" + str);
		for(Polynomial a : x) {
			System.out.print(a.coef+"x**" +a.exp+" + ");
		}
			
		System.out.println();
	}
}
