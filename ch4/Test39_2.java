package ch4; // answer

public class Test39_2 {
	public static void main(String[] args) {
		int[][] arr = new int[10][5];
		int num = 1;
		for(int i=0; i <arr.length; i++) {
			for(int j=0; j <arr[i].length; j++) {
				arr[i][j]=num++;
			}
		}
				for(int i=0; i <arr.length; i++) {
			for(int j=0; j <arr[i].length; j++) {
				System.out.print(arr[i][j]);
				System.out.print("\t");
			}
			System.out.println("");
		}

		int sum = 0;
		for(int i=0; i <arr.length && i <arr[i].length; i++) { // use && operator, 배열 요소 수의 actual number 변해도 adjustable code
			sum += arr[i][i];
		}
		
		System.out.println("\n"+"합: "+sum);
	}

}
