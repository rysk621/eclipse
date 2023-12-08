package ch4; // 참고

public class TestMatrix_2 {
	public static void main(String[] args) {
		int[][] arrA = {{1,2,3}, {4,5,6}};
		int[][] arrB = {{1,2},{3,4},{5,6}};
		
		for (int i=0; i<arrA.length; i++) {
			for(int j=0; j<arrB[0].length; j++) {
				int sum=0;
				for(int k=0; k<arrA[0].length; k++) { // TestMatrix_1과 다른 부분. 결과는 동일함. arrB.length == arrA[0].length (행렬 A*B가 성립하는 조건)
					sum+=(arrA[i][k]*arrB[k][j]);
				}
				System.out.print(sum+"\t");
			}
			System.out.print("\n");
		}
	}

}
