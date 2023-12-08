package ch05재귀함수;

import java.util.Stack;

//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
//N Queen problem / backtracking

//모든 해가 나오는 버젼 만들기 
/*
* 체스판은 8 x 8
* 체스의 기물: king/가로세로대각선 1칸만 이동, queen/가로세로 대각선/같은 편의 기물을 넘을 수 없다,
*  Rook/가로,세로 이동/다른 기물을 넘을 수없다, bishop/대각선, knight/1-2칸 이동/다른 기물을 넘을 수 있다,
*  pawn/처음 이동은 2칸까지 가능, 그 후 한칸만 가능, 잡을 때는 대각선 가능
*  체스판 최대 배치 문제 : king/16, Queen/8, rook/8, bishop/?, knight/?
*  rook 2개/a, h, knight 2개/b, g, bishop 2개/c, f, queen 1개/black queen은 black 칸에, 폰 8개
*/

class Point {
	int ix;
	int iy;

	public Point(int ix, int iy) {
		this.ix = ix;
		this.iy = iy;
	}
}

public class Backtracking_EightQueen2023 {
	static Stack<int[][]> bSt = new Stack<>();
	
	public static void solveQueen(int[][] d) {
		int count = 0; // 퀸 배치 갯수
		int ix = 0, iy = 0; // 행 ix, 열 iy
		Stack<Point> st = new Stack<>(); // 100개를 저장할 수 있는 스택을 만들고
		Point p = new Point(ix, iy); // 현 위치를 객체로 만들고
		d[ix][iy] = 1; // 현 위치에 queen을 넣었다는 표시를 하고
		count++;
		st.push(p); // 스택에 현 위치 객체를 push
		ix++; // ix는 행별로 퀸 배치되는 것을 말한다.
		int c = 1; // 답의 개수
		while (true) { // for loop로는 구현할 수 없음.
			if (st.isEmpty() && ix == 8) // ix가 8이면 8개 행에 배치 완료, stack이 empty가 아니면 다른 해를 구한다(st.isEmpty() => while loop를 빠져나간다).
				break;
			if ((iy = nextMove(d, ix, iy)) == -1) { // 다음 이동할 열을 iy로 주는데 -1이면 더이상 이동할 열이 없음을 나타냄
				if (st.isEmpty()) break;
				p = st.pop(); // stack 맨 위의 객체를 p에 전달한다.
				count--;
				ix = p.ix;
				iy = p.iy;
				d[ix][iy] = 0; // 초기화한다.
				iy++; // 다음 열을 확인한다.
				continue;
//				st.push(new Point(ix, iy));
//				if (ix != 7)
//					ix++;
//				iy = 0;
//				count++;
//				continue;
			} else {
				p = new Point(ix, iy);
				d[ix][iy] = 1;
				st.push(p);
				ix++;
				iy = 0;
				count++;
			}
			if (count == 8) { // 8개를 모두 배치하면
				System.out.println(c++ +"번째 답"); // 답의 개수 출력
				showQueens(d);
				bSt.add(d);
				p = st.pop();
				count--;
				ix = p.ix;
				iy = p.iy;
				d[ix][iy] = 0;
				iy++;
				continue;
			}

		}

	}

	// 배열 d에서 행 crow에 퀸을 배치할 수 있는지 조사
	public static boolean checkRow(int[][] d, int crow) {
		for (int i = 0; i < d[0].length; i++) {
			if (d[crow][i] == 1)
				return false;
		}
		return true;
	}

	// 배열 d에서 열 ccol에 퀸을 배치할 수 있는지 조사
	public static boolean checkCol(int[][] d, int ccol) {
		for (int[] i : d) {
			if (i[ccol] == 1)
				return false;
		}
		return true;
	}

	// 배열 d에서 행 cx, 열 cy에 퀸을 남서, 북동 대각선으로 배치할 수 있는지 조사
	public static boolean checkDiagSW(int[][] d, int cx, int cy) { // x++, y-- or x--, y++ where 0<= x,y <= 7
		int x = cx;
		int y = cy;
		int nRow = d.length, nCol = d[0].length;
		
		while ((x >= 0 && x < nRow) && (y >= 0 && y < nCol)) {
			if (d[x][y] == 1)
				return false;
			x++;
			y--;
		}
		
		x = cx;
		y = cy;
		while ((x >= 0 && x < nRow) && (y >= 0 && y < nCol)) {
			if (d[x][y] == 1)
				return false;
			x--;
			y++;
		}
		
		return true;
//		for (int i = cx, j = cy; i < d.length && j >= 0; i++, j--) {
//			if (d[i][j] == 1)
//				return false;
//		}
//		for (int i = cx, j = cy; i >= 0 && j < d.length; i--, j++) {
//			if (d[i][j] == 1)
//				return false;
//		}
//		return true;
	}

	// 배열 d에서 행 cx, 열 cy에 퀸을 남동, 북서 대각선으로 배치할 수 있는지 조사
	public static boolean checkDiagSE(int[][] d, int cx, int cy) {// x++, y++ or x--, y--
		int x = cx;
		int y = cy;
		int nRow = d.length, nCol = d[0].length;
		
		while ((x >= 0 && x < nRow) && (y >= 0 && y < nCol)) {
			if (d[x][y] == 1)
				return false;
			x++;
			y++;
		}
		
		x = cx;
		y = cy;
		while ((x >= 0 && x < nRow) && (y >= 0 && y < nCol)) {
			if (d[x][y] == 1)
				return false;
			x--;
			y--;
		}
		return true;
//		for (int i = cx, j = cy; i < d.length && j < d.length; i++, j++) {
//			if (d[i][j] == 1)
//				return false;
//		}
//		for (int i = cx, j = cy; i >= 0 && j >= 0; i--, j--) {
//			if (d[i][j] == 1)
//				return false;
//		}
//		return true;
	}

	// 배열 d에서 (x,y)에 퀸을 배치할 수 있는지 조사
	public static boolean checkMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check (상기 함수 사용)
		if (checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y))
			return true;
		else
			return false;
	}

	// 배열 d에서 현재 위치(row,col)에 대하여 다음에 이동할 위치 nextCol을 반환, 이동이 가능하지 않으면 -1를 리턴
	public static int nextMove(int[][] d, int row, int col) {
		// 현재 row에서 각 col에 대하여 이동이 가능한 col이 있다면 해당 col의 index를 return. checkMove()를 call
		// 해야함.
		for (int i = col; i < d.length; i++) {
			if (checkMove(d, row, i))
				return i;
		}
		return -1;
	}

	static void showQueens(int[][] data) {// 배열 출력
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int row = 8, col = 8;
		int[][] data = new int[row][col];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				data[i][j] = 0;
			}
		}
		System.out.println("raw board::");
		showQueens(data);
//		System.out.println(checkDiagSE(data, 7, 7));
		System.out.println("after solveQueen() method::");
		solveQueen(data);
//		for (int i = 0; i < bSt.size(); i++) {
//			System.out.println(i+"번째");
//			showQueens(bSt.get(i));
//		}
	}
}
