package ch05재귀함수;

import java.util.ArrayList;
import java.util.List;

enum Directions {
	N, NE, E, SE, S, SW, W, NW
}

class Items {
	int x;
	int y;
	int dir;

	public Items(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.dir = d;
	}

	@Override
	public String toString() {
		return "x = " + x + ", y = " + y + ", dir = " + dir;
	}
}

class Offsets {
	int a;
	int b;

	public Offsets(int a, int b) {
		this.a = a;
		this.b = b;
	}
}

class StackList {
	private List<Items> data; // 스택용 배열. Items type의 객체 저장하는 List data 선언. Items는 현재 위치 x, y와 이동방향 dir를 필드값으로
								// 갖는 클래스.
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	// --- 실행시 예외 : 스택이 비어있음 ---//
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
		}
	}

	// --- 실행시 예외 : 스택이 가득 참 ---//
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
		}
	}

	// --- 생성자(constructor) ---//
	public StackList(int maxlen) { // capacity 전달받아 new ArrayList data를 생성함.
		top = 0;
		capacity = maxlen;
		try {
			data = new ArrayList<>(0); // 스택 본체용 배열을 생성, initial capacity를 전달받는다.
		} catch (OutOfMemoryError e) { // 생성할 수 없음
			capacity = 0;
		}
	}

	// --- 스택에 x를 푸시 ---//
	public void push(Items p) throws OverflowIntStackException {
		if (top >= capacity) // 스택이 가득 참
			throw new OverflowIntStackException();
		data.add(p);
		top++;
		return;
	}

	// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Items pop() throws EmptyIntStackException {
		if (top <= 0) // 스택이 빔
			throw new EmptyIntStackException();
		return data.remove(--top);
	}

	// --- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Items peek() throws EmptyIntStackException {
		if (top <= 0) // 스택이 빔
			throw new EmptyIntStackException();
		return data.get(top - 1);
	}

	// --- 스택을 비움 ---//
	public void clear() {
		top = 0;
	}

	// --- 스택에서 x를 찾아 인덱스(벌견하지 못하면 –1)를 반환 ---//
	public int indexOf(Items x) {
		for (int i = top - 1; i >= 0; i--) // 정상 쪽에서 선형검색
			if (data.get(i).equals(x))
				return i; // 검색 성공
		return -1; // 검색 실패
	}

	// --- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

	// --- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

	// --- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return top <= 0;
	}

	// --- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return top >= capacity;
	}

	// --- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
	public void dump() {
		if (top <= 0)
			System.out.println("스택이 비어있습니다.");
		else {
			for (int i = 0; i < top; i++)
				System.out.print(data.get(i) + " ");
			System.out.println();
		}
	}
}

public class Maze {

	static Offsets[] moves = new Offsets[8]; // static을 선언하는 이유를 알아야 한다.

	public static void path(int[][] maze, int[][] mark, int ix, int iy) { // path method는 (배열 maze, 배열 mark, exit의 index
																			// ix, iy) 전달받는다.

		mark[1][1] = 1;
		StackList st = new StackList(50); // capacity 50인 스택리스트 생성. StackList객체는 List<Items> data = new ArrayList<>(0);
											// 이용해 ArrayList인 data를 생성.
		Items temp = new Items(1, 1, 2); // N :: 0. Items의 parameter(int x, int y, int dir): (x,y)와 방향 설정하는 enum의
											// element dir를 전달.
//		temp.x = 1;
//		temp.y = 1;
//		temp.dir = 2; // 2는 direction E (given code ==> new Items(1,1,2)로 주기로 함.)
		mark[temp.x][temp.y] = 2; // 미로 찾기 궤적은 2로 표시
		st.push(temp); // stacklist st에 temp 저장(temp는 (x=1,y=1,dir=2)로 초기화되어있다.)

		while (!st.isEmpty()) { // stack is not empty
			Items tmp = st.pop(); // unstack
			int i = tmp.x;
			int j = tmp.y;
			int d = tmp.dir;
			while (d < 8) { // moves forward
				int g = i + moves[d].a;
				int h = j + moves[d].b;
				mark[i][j] = 2; // 현재 위치를 2로 표시함(미로찾기 궤적)
				if ((g == ix) && (h == iy)) { // reached exit
//					mark[i][j] = 2;
					mark[g][h] = 2;
					return; // output path
				}
				if ((maze[g][h] == 0) && (mark[g][h] == 0)) { // legal move && new position
//					mark[i][j] = 2;
					mark[g][h] = 2;
					Items nTemp = new Items(i, j, ++d); // ++d해주기, 안해도 결과는 동일할 수 있지만 loop를 한 번 더 돌 것.
					st.push(nTemp);
					d = 0; // d = N으로 초기화.
					i = g;
					j = h;
					continue;
				} else {
//					d = N; d가 증가해야한다.
					d++;
				}
			}
			mark[i][j] = 1; // 두번째 while loop 바깥의 mark[i][j]는 갈 수 있는 direction 없음, backtracking.
							// backtracking 궤적은 1로 표시
		}
		System.out.println("no path in the maze");
	}

	static void showMatrix(int[][] d, int row, int col) { // showMatrix method: int[][] d를 출력하는 method
		for (int i = 0; i <= row; i++) {
			System.out.print(" ");
			for (int j = 0; j <= col; j++) {
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] maze = new int[14][17];
		int[][] mark = new int[14][17];

		int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 }, 
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 }, 
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 }, 
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 }, 
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 } };
		for (int ia = 0; ia < 8; ia++) {
			moves[ia] = new Offsets(0, 0);
		} // 배열에 offsets 객체를 치환해야 한다.
		moves[0].a = -1;
		moves[0].b = 0;
		moves[1].a = -1;
		moves[1].b = 1;
		moves[2].a = 0;
		moves[2].b = 1;
		moves[3].a = 1;
		moves[3].b = 1;
		moves[4].a = 1;
		moves[4].b = 0;
		moves[5].a = 1;
		moves[5].b = -1;
		moves[6].a = 0;
		moves[6].b = -1;
		moves[7].a = -1;
		moves[7].b = -1;
		// Directions d;
		// d = Directions.N;
		// d = d + 1;//java는 지원안됨
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
				// input[][]을 maze[][]로 변환
				if (i != 0 && i != 13 && j != 0 && j != 16)
					maze[i][j] = input[i - 1][j - 1];
				else
					maze[i][j] = 1;
			}
		}
		System.out.println(" maze[12,15]::");
		showMatrix(maze, 13, 16); // row 0-13, column 0-16인 int[][] maze를 출력
		System.out.println();

		System.out.println(" mark::");
		showMatrix(mark, 13, 16);
		System.out.println();

		path(maze, mark, 12, 15);
		System.out.println(" mark::");
		showMatrix(mark, 13, 16);
	}
}
