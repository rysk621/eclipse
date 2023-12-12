package ch06정렬알고리즘;

import java.util.Random;
import java.util.Scanner;

interface MaxHeap {
	public void insert(int x);
	public int deleteMax();
}

class Heap implements MaxHeap {
	final int heapSize = 100;
	private int[] heap;
	private int n; // current size of MaxHeap
	private int maxSize; // Maximum allowable size of MaxHeap

	// constructor
	public Heap(int sz) {
		heap = new int[sz+1];
	}

	public void display() {
		for (int a : heap) {
			System.out.print(a+" ");
		}
		System.out.println();
	}

	@Override
	public void insert(int x) {
		
	}

	@Override
	public int deleteMax() {

	}

	private void heapEmpty() {
		if (n == 0)
			System.out.println("Heap is Empty.");
	}

	private void heapFull() {
		if (n == maxSize)
			System.out.println("Heap is Full.");
	}
}

public class HeapSort {
	static void showData(int[] d) {
		for (int i = 0; i < d.length; i++) {
			System.out.print(d[i]);
			if (i!=d.length-1) System.out.print(", ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Random rnd = new Random();
		int select = 0;
		Scanner stdIn = new Scanner(System.in);
		Heap heap = new Heap(20);
		final int count = 10;
		int[] x = new int[count + 1];
		int[] sorted = new int[count];

		do {
			System.out.print("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1:
				System.out.print("value to insert : ");
				int val = stdIn.nextInt();
				heap.insert(val);
				break;

			case 2:
				heap.display();
				break;

			case 3:

				break;

			case 4:
				return;
			}
		} while (select < 5);

		return;
	}
}
