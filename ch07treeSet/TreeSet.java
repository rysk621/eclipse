package ch07treeSet;

class Sets {
	private int[] parent;
	private int n;
	
	public Sets(int sz) {
		n = sz;
		parent = new int[sz + 1]; // Don't want to use parent[0]
		for (int i = 0; i < n; i++)
			parent[i] = -1; // 0 for Simple versions
	}

	public void display() {
		System.out.println("\n<sets>");
		for (int i = 1; i <= n; i++)
			System.out.print(" " + i);
		System.out.println("\n<parent sets>");
		for (int i = 1; i <= n; i++)
			System.out.print(" " + parent[i]);
		System.out.println("\n");
	}

	public void SimpleUnion(int i, int j) {
		// Replace the disjoint sets with roots i and j, i != j with their union
		while (parent[i] > 0)
			i = parent[i];
		while (parent[j] > 0)
			j = parent[j];
		int num = parent[i] + parent[j];
		System.out.println("i = " + i + "\t: j = " + j);
		if (i != j) {
			parent[j] = i;
			parent[i] = num;
		}
	}

	public int SimpleFind(int i) {
		// Find the root of the tree containing element i
		while (parent[i] > 0)
			i = parent[i];
		return i;
	}

	public void WeightedUnion(int i, int j) {
		// Union sets with roots i and j, i != j, using the weighting rule.
		// parent[i]~=~-count[i] and parent[i]~=~-count[i]. 절댓값이 node의 개수
		while (parent[i] > 0)
			i = parent[i];
		while (parent[j] > 0)
			j = parent[j];
		if (i == j) return; //same set : return
		int temp = parent[i] + parent[j];
		if (parent[i] > parent[j]) { // i has fewer nodes
			parent[i] = j;
			parent[j] = temp;
		} else { // j has fewer nodes
			parent[j] = i;
			parent[i] = temp;
		}
	}

	public int CollapsingFind(int i) {
		// Find the root of the tree containing element i.
		// Use the collapsing rule to collapse all nodes from @i@ to the root
		int r;
		for (r = i; parent[r] > 0; r = parent[r])
			; // find root
		while (i != r) {
			int s = parent[i];
			parent[i] = r;
			i = s;
		}
		return r;
	}
}

public class TreeSet {
	public static void main(String[] args) {

		Sets s1 = new Sets(20);
		s1.SimpleUnion(7, 1);
		s1.SimpleUnion(2, 3);
		s1.SimpleUnion(4, 5);
		s1.SimpleUnion(6, 7);
		s1.SimpleUnion(4, 2);
		s1.SimpleUnion(5, 7);
		int n = s1.SimpleFind(1);
		System.out.println(""+n);
		s1.SimpleUnion(9, 11);
		s1.SimpleUnion(13, 9);
		s1.display();
		int n1 = s1.SimpleFind(5);
		int n2 = s1.SimpleFind(7);
		System.out.println("5의 parent = " + n1 + ", 7의 parent = " + n2);
		s1.WeightedUnion(1, 2);
		s1.WeightedUnion(3, 4);
		s1.WeightedUnion(5, 6);
		s1.WeightedUnion(7, 8);
		s1.display();
		System.out.println("find 5: " + s1.CollapsingFind(5));// simpleUnion과 WeightedUnion 무한루프 주의, 코드 일부분 고쳐야 함
		System.out.println("find 6: " + s1.CollapsingFind(6));
		s1.WeightedUnion(1, 3);
		s1.WeightedUnion(5, 7);
		s1.display();
		System.out.println("find 5: " + s1.CollapsingFind(5));
		System.out.println("find 6: " + s1.CollapsingFind(6));
		System.out.println("find 7: " + s1.CollapsingFind(7));
		System.out.println("find 8: " + s1.CollapsingFind(8));
		s1.WeightedUnion(1, 5);
		s1.display();
		System.out.println("find 1: " + s1.CollapsingFind(1));
		System.out.println("find 2: " + s1.CollapsingFind(2));
		System.out.println("find 3: " + s1.CollapsingFind(3));
		System.out.println("find 4: " + s1.CollapsingFind(4));
		System.out.println("find 5: " + s1.CollapsingFind(5));
		System.out.println("find 6: " + s1.CollapsingFind(6));
		System.out.println("find 7: " + s1.CollapsingFind(7));
		System.out.println("find 8: " + s1.CollapsingFind(8));
		s1.display();

	}
}
