package ch06정렬알고리즘;

public class MergeArray {
	static void merge(int[] a, int na, int[] b, int nb, int[] c) {
		int pa = 0;
		int pb = 0;
		int pc = 0;
//		작은 쪽의 값을 c[]에 저장
		while (pa < na && pb < nb) c[pc++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];
		
//		a[]에 남아있는 요소를 c[]에 저장
		while (pa < na) c[pc++] = a[pa++];
//		b[]에 남아있는 요소를 c[]에 저장
		while (pb < nb) c[pc++] = b[pb++];
	}
	
	public static void main(String[] args) {
		int[] a = {2,4,6,8,11,13};
		int[] b = {1,2,3,4,9,16,21};
		int[] c = new int[13];
		
		merge(a, a.length, b, b.length, c);
	}
}
