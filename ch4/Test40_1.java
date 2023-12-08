package ch4; // 배열 행렬의 각 요소 개수 확인,,, 지금은 i>j라서 맞음.

public class Test40_1 {
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
			System.out.println("\n");
		}
		for(int i=0; i < arr.length; i++) { // i<arr.length일 경우 열 길이 넘는 행도 다 나타남. i<arr[i].length일 경우 5열이므로 5행 아래는 표시되지 않음. i>=j일 경우에 arr[i].length로 설정하면 exception 발생하므로 주의.
			for(int j=0; j <= i && j < arr[i].length; j++) { // j는 i에 종속되어 있음, arr[i]도 마찬가지. i=j일 때도 print하려고 하므로 이 줄의 조건문에서 j <= i를 설정.
					System.out.print(arr[i][j]);
					System.out.print("\t");
			}
			System.out.println("\n");
		}
		
		int sum = 0;
		for(int i=0; i <arr.length && i <arr[i].length; i++) {
			sum += arr[i][i];
		}
		System.out.println("\n"+"합: "+sum);
	}

}
