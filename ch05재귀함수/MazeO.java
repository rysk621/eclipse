package ch05재귀함수;

import java.util.ArrayList;
import java.util.List;

enum Directions1 {
	E, SE, S, SW, W, NW, N, NE
}

class Rat{
	int x;
	int y;
	int dir;
	public Rat(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}

class Moves{
	int a;
	int b;

	public Moves(int a, int b) {
		this.a = a;
		this.b = b;
	}
}

class PositionList{
	private List<Rat> list; // 위치좌표 stack하기 위한 list 선언.
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터
	// --- 실행시 예외 : 스택이 비어있음 ---//

	public class EmptyStackException extends RuntimeException {
		public EmptyStackException() {
		}
	}

	// --- 실행시 예외 : 스택이 가득 참 ---//
	public class OverflowStackException extends RuntimeException {
		public OverflowStackException() {
		}
	}

//	스택의 생성자(최대 길이를 parameter로 전달받는다.)
	public PositionList(int maxLen) {
		top = 0;
		capacity = maxLen;

		try {
			list = new ArrayList<>(0);
		}catch(OutOfMemoryError e) {
			capacity = 0;
			System.out.println(e.getMessage());
		}
	}

	public void push(Rat r) throws OverflowStackException {
		if (top >= capacity) throw new OverflowStackException();
		list.add(r);
		top++;
		return;
	}
	
	public Rat pop() throws EmptyStackException {
		if (top <= 0) // 스택이 빔
			throw new EmptyStackException();
		return list.remove(--top);
	}
	
	public boolean isEmpty() {
		return top <= 0;
	}
	
	public int size() {
		return top;
	}
}

public class MazeO {
	static Moves[] move = new Moves[8]; // enum class 객체 생성 없이 사용하기 위해 static 선언한다. 
	
	public static void main(String[] args) {
		int[][] maze = new int[14][17];
		int[][] mark = new int[14][17];
		
		int input[][] = {
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
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }
		};
		
//		1. Moves 객체 만든다.
		for (int i = 0; i < 8; i++) {
			move[i] = new Moves(0,0);
		}
//		2. Moves 객체 setting(각 필드 default로 선언되어 있음): E to NE
		move[0].a = 0;
		move[0].b = 1;
		move[1].a = 1;
		move[1].b = 1;
		move[2].a = 1;
		move[2].b = 0;
		move[3].a = 1;
		move[3].b = -1;
		move[4].a = 0;
		move[4].b = -1;
		move[5].a = -1;
		move[5].b = -1;
		move[6].a = -1;
		move[6].b = 0;
		move[7].a = -1;
		move[7].b = 1;
		
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

	private static void path(int[][] maze, int[][] mark, int n, int m) {
		PositionList st = new PositionList(50);
		Rat start = new Rat(1,1,0); // Rat의 초기 좌표, 초기 방향 설정
		
		mark[start.x][start.y] = 2; // Rat의 궤적 표시: 2로 표시한다.
		st.push(start);
		
		while(!st.isEmpty()) { // if stack is empty --> there's no path in the maze.
			Rat solid = st.pop(); // 여기서 stack element pop 했으므로 while loop 처음 돌 때는 stack size = 0.  
			int i = solid.x;
			int j = solid.y;
			int d = solid.dir;

			while(d<8) {
				int g = i + move[d].a;
				int h = j + move[d].b; // g, h 좌표 설정 ==> 다음 갈 곳이 legal move인지 확인하기 위함.
				if ((g == n) && (h == m)) { // if maze[g][h] is the exit
					i = g;
					j = h;
					mark[i][j] = 2; // 진행, 2로 marking
					System.out.println(" stack의 size = "+st.size());
					return; // path() method exit
				}
				if ((maze[g][h] == 0) && (mark[g][h] == 0)) { // if legal move
					Rat shade = new Rat(i, j, ++d); // shade rat 객체 생성, ++d해주기, 안해도 결과는 동일할 수 있지만 loop를 한 번 더 돌 것.
					st.push(shade); // 다음 방향을 향하는 Rat 객체(shade) stack에 저장하고 다음번(되돌아올 경우)에 사용할 것.
//					start.dir = ++d; // 주석처리한 두 줄처럼 하면 안됨, 막다른길에 도달하면 loop 끝내버려서 backtracking의 의미가 없음. "no path" message 출력.
//					st.push(start); // ==> "새로운 객체" 생성해서 넣어줘야 backtrack하여 다른 길을 찾을 수 있다.
					i = g;
					j = h;
					d = 0; // 위치 이동 후 방향 초기화, 다시 E부터 track finding.
					mark[i][j] = 2; // 이동 후의 현재 위치 marking
					continue; // 바로 위의 while loop로 되돌아감.
				} else { // if illegal move (다음 갈 곳이 길이 아니거나(maze[g][h]!=0) || 이미 들렀던 곳(mark[g][h]!=0)일 경우)
					d++; // 방향 전환.
				}
			}
			mark[i][j] = 0; // 더이상 갈 곳이 없어지면 현재 위치(막다른곳) 1로 변경하여 backtracking print.
							// 여기서 0으로 표시하면 backtrack 표시되지 않음. 
		}
		System.out.println(" stack size = "+st.size()); // no path 인 경우이므로 st.size() == 0일 것.
		System.out.println(" no path in the maze");
	}

	private static void showMatrix(int[][] d, int row, int col) {
		for (int i = 0; i <= row; i++) {
			System.out.print(" ");
			for (int j = 0; j <= col; j++) {
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
	}
}
