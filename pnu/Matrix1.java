package pnu;

import java.util.Arrays;
import java.util.Random;

class Matrix {
	private int m[][];

	public Matrix(Matrix mA, Matrix mB) {
		this.m = new int[mA.m.length][mB.m[0].length];
	};

	public Matrix(int[] array, int start, int row, int column) {
		this.m = new int[row][column];

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = array[start];
				start++;
			}
		}
	}

	public static Matrix sum(Matrix mA, Matrix mB) {
		Matrix mSum = new Matrix(mA, mB);
		for (int i = 0; i < mA.m.length; i++) {
			for (int j = 0; j < mA.m[0].length; j++) {
				mSum.m[i][j] = mA.m[i][j] + mB.m[i][j];
			}
		}
		return mSum;
	}

	public static Matrix times(Matrix mA, Matrix mB) {
		Matrix mTimes = new Matrix(mA, mB);
		for (int i = 0; i < mA.m.length; i++) {
			for (int j = 0; j < mB.m[0].length; j++) {
				int sum = 0;
				for (int k = 0; k < mA.m[0].length; k++) {
					sum += (mA.m[i][k] * mB.m[k][j]);
				}
				mTimes.m[i][j] = sum;
			}
		}
		return mTimes;
	}

	public void print() {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	};
}

public class Matrix1 {
	public static void sortArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		Random rand = new Random();
		int[] array = new int[24];
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(11);
		}
		
		for (int i = 0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		};
		System.out.println();
		System.out.println(Arrays.toString(array));
//		Arrays.sort(array);
		sortArray(array);
		System.out.println(Arrays.toString(array));
		
		System.out.println("=".repeat(20));
		System.out.println("행렬 mA");
		Matrix mA = new Matrix(array, 0, 3, 4);
		mA.print();
		
		System.out.println("=".repeat(20));
		System.out.println("행렬 mB");
		Matrix mB = new Matrix(array, 12, 3, 4);
		mB.print();
		
		System.out.println("=".repeat(20));
		System.out.println("행렬의 합 (mA + mB)");
		Matrix mC = Matrix.sum(mA, mB);
		if (mC != null) mC.print();
		
		System.out.println("=".repeat(20));
		System.out.println("행렬 mD");
		Matrix mD = new Matrix(array, 0, 4, 3);
		mD.print();
		
		System.out.println("=".repeat(20));
		System.out.println("행렬의 곱 (mA * mD)");
		Matrix mE = Matrix.times(mA, mD);
		mE.print();
	}
}
