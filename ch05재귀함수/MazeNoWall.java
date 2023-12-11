package ch05재귀함수;

public class MazeNoWall {
	static Moves[] move = new Moves[8];
	
	private static void path(int[][] maze, int[][] mark, int row, int col) {
		
		PositionList list = new PositionList(100); // defined in class MazeO
		Rat r = new Rat(0,0,0); // rat in the starting point
		list.push(r); // push rat to stack
		
		int route = 3;
		mark[r.x][r.y] = route; // 3으로 route marking
		
		while(!list.isEmpty()) {
			Rat solid = list.pop();
			int a = solid.x;
			int b = solid.y;
			int dir = solid.dir;
			
			while (dir < 8) {
//				next move(n,m)는 direction loop 안에 있어야 else 문의 dir++ 영향을 받음
				int n = a + move[dir].a;
				int m = b + move[dir].b;
				mark[a][b] = route;
				if (n >= 0 && n < row && m >= 0 && m < col && n == row-1 && m == col-1) { // if next move is exit
					mark[n][m] = route;
					return;
				}
				
				if (n >= 0 && n < row && m >= 0 && m < col && mark[n][m] == 0 && maze[n][m] == 0) { // if next move(n,m) is legal
					Rat shadow = new Rat(a,b,++dir); // 이전 position에 객체 생성, dir는 증가시켜둔다.
					list.push(shadow); // 생성한 객체 stack에 저장해둔다. 저장하지 않으면 backtracking 불가능
					mark[n][m] = route;
					a = n;
					b = m;
					dir = 0; // 이동 및 방향 초기화(찾지 않는 방향 없기 위해 초기화 필요함.)
					continue;
				}else {
					dir++;
				}
			}
			mark[a][b] = 0; // backtrack 기록 남기지 않음
		}
		System.out.println("There's no path in the maze.");
	}
	
	static void showMatrix(int[][] d, int row, int col) { // showMatrix method: int[][] d를 출력하는 method
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] input = {
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
		int[][] maze = new int[12][15];
		int[][] mark = new int[12][15];
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 15; j++) {
				// input[][]을 maze[][]로 변환
					maze[i][j] = input[i][j];
			}
		}
		
		for (int i = 0; i < 8; i++) {
			move[i] = new Moves(0,0); // ###Moves 객체 사용###
		}
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
		
		System.out.println("<maze board> (w/o wall)");
		showMatrix(maze, 12, 15);
//		System.out.println("\n<mark board>");
//		showMatrix(mark, 12, 15);
		path(maze, mark, 12, 15);
		System.out.println("\n<maze pathfinding> (w/o backtrack record)");
		showMatrix(mark, 12, 15);
	}

}
