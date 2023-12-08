package ch4; // 맞긴 맞음, print 되긴 함

public class Test40 {
	public static void main(String[] args) {
		int[][] arr = new int[5][5]; // rows/columns 개수 설정
		int num = 1;
		for(int i=0; i <arr.length; i++) {
			for(int j=0; j <arr[i].length; j++) {
				arr[i][j]=num++;
			}
		}		
		for(int i=0; i <arr.length; i++) {
			for(int j=0; j <= i; j++) { // 설정한 rows/columns 개수 주의, exception 발생. (arr.length>arr[i].length이면 exception 발생)
				System.out.print(arr[i][j]);
				System.out.print("\t");
			}
			System.out.println("");
		}

		int sum = 0;
		for(int i=0; i <arr.length; i++) {
			for(int j=0; j <=i; j++)
			sum += arr[i][j];
		}
		
		System.out.println("\n"+"합: "+sum);
	}

}
