package ch4;

import java.util.Scanner; //ctrl+shift+o --> 자동으로 import

public class Test01 {
//	public static void main(String[] args) {
//		int[] arr = new int[5];
//		arr[0] = 10;
//		arr[1] = 20;
//		arr[2] = 30;
//		arr[3] = 40;
//		arr[4] = 50;
//		
//		System.out.println(arr[0]);
//		System.out.println(arr[1]);
//		System.out.println(arr[2]);
//		System.out.println(arr[3]);
//		System.out.println(arr[4]);
//		System.out.println("-".repeat(20));
	
//		for(int i=0;i<5;i++) --> for(int i=0;i<arr.length;i++)
//			System.out.println(arr[i]);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //System.in: 기본 input으로부터 받음
		
		int arr[] = new int[3];
		
		System.out.print("국어 점수: "); //System.out: 기본 output device로 아웃풋
		arr[0] = sc.nextInt();
		
		System.out.print("영어 점수: ");
		arr[1] = sc.nextInt();
		
		System.out.print("수학 점수: ");
		arr[2] = sc.nextInt();
		
		System.out.println("traditional for loop");
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("advanced for loop"); //arr.length를 몰라도 됨
		for(int i:arr) {
			System.out.println(i);
		}
		
		
		int avg = (arr[0]+arr[1]+arr[2])/3;
		System.out.println("평균은 "+avg);
		
		sc.close();
		}

}
