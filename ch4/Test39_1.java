package ch4;

public class Test39_1 {
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
		for(int i=0; i <arr[i].length; i++) { // 이렇게 하면 i<j일때는 또 안됨 (arr[i]의 길이가 또 j+1이 되므로. i=j+1일 때는 되겠다)
			sum += arr[i][i];
		}
		
		System.out.println("\n"+"합: "+sum);
	}

}
