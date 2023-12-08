package ch02기본자료구조;

import java.util.Random;

public class 다차원배열 {
	public static void main(String[] args) {
		int[][] A = new int[2][3];
		int[][] B = new int[3][4];
		int[][] C = new int[2][4]; // A * B
		int[][] D = new int[2][3];
		inputData(A);
		inputData(B);
		inputData(D);
		System.out.println("A[2][3]");
		showData(A);
		System.out.println("\nD[2][3]");
		showData(D);
		System.out.println("\nB[3][4]");
		showData(B);
		System.out.println("\nC[2][4]");
		inputData(C);
		showData(C);
		int[][] E = addMatrix(A, D);
		System.out.println("\nE[2][3] (add A and D)");
		showData(E);
		int[][] C1 = multiplyMatrix(A,B);
		System.out.println("\nC1[2][4] (multiply A and B)");
		showData(C1);
		int[][] F = transposeMatrix(A);
		System.out.println("\nF[3][2] (transpose A)");
		showData(F);
		boolean result = equals(A, D);
		System.out.println("\nequals(A,D) = " + result);
	}

	private static int[][] transposeMatrix(int[][] a) {
		 int b[][] = new int[a[0].length][a.length];
		 for (int i =0;i<a.length;i++) {
			 for (int j = 0; j<a[0].length;j++) {
				 b[j][i] = a[i][j];
			 }
		 }
		return b;
	}

	private static int[][] multiplyMatrix(int[][] a, int[][] b) {
		int[][] c = new int[a.length][b[0].length];
		for (int i = 0; i<a.length;i++) {
			for (int j = 0; j<a[0].length;j++) {
				int sum = 0;
				for (int k = 0; k<a[0].length;k++) {
					sum += a[i][k] * b[k][j];
				}
				c[i][j] = sum;
			}
		}
		return c;
	}

	static void inputData(int[][] data) {
		Random rand = new Random();

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				data[i][j] = rand.nextInt(11);
			}
		}
	}

	static void showData(int[][] items) {
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items[0].length; j++) {
				System.out.print(items[i][j]+"\t");
			}
			System.out.println();
		}
	}

	static boolean equals(int[][] a, int[][] b) {
		for (int i = 0; i <a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] != b[i][j]) return false;
			}
		}
		return true;
	}

	static int[][] addMatrix(int[][] X, int[][] Y) {
		int[][] Z = new int[X.length][X[0].length];
		for (int i = 0; i < X.length; i++) {
			for (int j = 0; j < X[0].length; j++) {
				Z[i][j] = X[i][j] + Y[i][j];
			}
		}
		return Z;
	}

}
