package ch4;

import java.util.Scanner;

public class Test37_1 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in); //ctrl+shift+o로 자동 import
	int[] score = new int[5];
	
	score[0] = sc.nextInt();
	score[1] = sc.nextInt();
	score[2] = sc.nextInt();
	score[3] = sc.nextInt();
	score[4] = sc.nextInt();
	
	int sum = 0;
	double avg = 0.0;
	int max = 0;
	int min = 999;
	
	for(int i=0; i<score.length; i++) {
		sum += score[i];
		if(max<score[i])
			max = score[i];
		if(min>score[i])
			min = score[i];
	}
	
	avg = sum / score.length;
	System.out.println("총	점: "+sum);
	System.out.println("평	균: "+avg);
	System.out.println("최댓값: "+max);
	System.out.println("최솟값: "+min);
	
	sc.close();
	}

}
