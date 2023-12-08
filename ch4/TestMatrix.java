package ch4; // 다 했음. 변수 선언 위치 주의할 것.

public class TestMatrix {
	public static void main(String[] args) {
		int[][] arrA = new int[2][3];
		int[][] arrB = new int[3][2];

		int anum = 1;
		for (int i = 0; i < arrA.length; i++) {
			for (int j = 0; j < arrA[i].length; j++) {
				arrA[i][j] = anum++;
				System.out.print(arrA[i][j] + "\t");
			}
			System.out.print("\n");
		}
		System.out.print("\n");

		int bnum = 1;
		for (int i = 0; i < arrB.length; i++) {
			for (int j = 0; j < arrB[i].length; j++) {
				arrB[i][j] = bnum++;
				System.out.print(arrB[i][j]);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		System.out.print("\n");

		for (int i = 0; i < arrA.length; i++) {
			for (int j = 0; j < arrB[0].length; j++) {
				int sum=0;									// 변수 선언 위치 주의. for문 맨 위에 뒀더니 sum 결과가 틀어졌음ㅜㅜ
				for (int k=0; k < arrA[0].length; k++) {
					sum += (arrA[i][k] * arrB[k][j]);
				}
				System.out.print(sum + "\t");
			}
			System.out.print("\n");
		}
	}

}
