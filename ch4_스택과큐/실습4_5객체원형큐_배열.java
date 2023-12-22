package ch4_스택과큐;
/*
 * 원형 큐로서 큐에 Point 객체를 저장 - 교재 소스코드를 원형 큐가 되도록 수정하는 연습
 */

import java.util.Random;
import java.util.Scanner;

class Point4 {
	private int ix;
	private int iy;

	public Point4(int x, int y) {
		ix = x;
		iy = y;
	}

	@Override
	public String toString() {
		return "<" + ix + ", " + iy + ">";
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}

	@Override
	public boolean equals(Object p) {
		if ((this.ix == ((Point4) p).ix) && (this.iy == ((Point4) p).iy))
			return true;
		else
			return false;
	}
}

public class 실습4_5객체원형큐_배열 {

	static int QUEUE_SIZE = 0;
	Point4[] que;// 배열로 객체원형 큐 구현
	int front, rear;
	int num;
	static boolean isEmpty;

	// --- 실행시 예외: 큐가 비어있음 ---//
	public class EmptyQueueException extends RuntimeException {
		public EmptyQueueException() {
		}
	}

	// --- 실행시 예외: 큐가 가득 찼음 ---//
	public class OverflowQueueException extends RuntimeException {
		public OverflowQueueException() {
		}
	}

//	생성자
	public 실습4_5객체원형큐_배열(int count) {
		QUEUE_SIZE = count;
		front = rear = num = 0;
		que = new Point4[count];
	}

	void push(Point4 it) throws OverflowQueueException {
//	push() method 구현
		if (num >= QUEUE_SIZE)
			throw new OverflowQueueException();
		que[rear++] = it;
		num++;
		if (rear == QUEUE_SIZE)
			rear = 0;
	}

	Point4 pop() throws EmptyQueueException {
//		pop() method 구현
		if (num <= 0)
			throw new EmptyQueueException();
		Point4 x = que[front++];
		num--;
		if (front == QUEUE_SIZE)
			front = 0;
		return x;
	}

	void clear() {
		for (int i = 0; i < que.length; i++) {
			que[i] = null;
			front = rear = 0;
		}
		isEmpty = true;
		System.out.println("원형 큐가 비었습니다.");
	}

	// --- 큐의 크기를 반환 ---//
	public int getCapacity() {
		return QUEUE_SIZE;
	}

	// --- 큐에 쌓여 있는 데이터 개수를 반환 ---//
	public int size() {
		return num;
	}

//	dump() method 구현: front - rear 순서
	public void dump() {
		if (num <= 0)
			throw new EmptyQueueException();
		System.out.println("프론트->리어 순 출력");
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % QUEUE_SIZE;
			if (idx==(num-1)) System.out.print(que[idx]);
			else System.out.print(que[idx] + ", ");
		}
		System.out.println();
	}

//	peek() method: front 데이터 보기
	public Point4 peek() throws EmptyQueueException {
		if (num <= 0)
			throw new EmptyQueueException();
		return que[front];
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		실습4_5객체원형큐_배열 oq = new 실습4_5객체원형큐_배열(4); // 최대 64개를 인큐할 수 있는 큐
		Random random = new Random();
		int rndx = 0, rndy = 0;
		Point4 p = null;
		while (true) {
			System.out.println("=".repeat(30)); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", oq.size(), oq.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료: ");
			int menu = stdIn.nextInt();
			if (menu == 0)
				break;
			switch (menu) {
			case 1: // 인큐
				rndx = random.nextInt(20);
				rndy = random.nextInt(20);
				p = new Point4(rndx, rndy);
				try {
					oq.push(p);
					System.out.println("입력데이터: (" + rndx + ", " + rndy + ")");
				} catch (실습4_5객체원형큐_배열.OverflowQueueException e) {
					System.out.println("큐가 가득 찼습니다.");
				}
				break;

			case 2: // 디큐
				try {
					p = oq.pop();
					System.out.println("디큐한 데이터는 " + p + "입니다.");
				} catch (실습4_5객체원형큐_배열.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = oq.peek();
					System.out.println("피크한 데이터는 " + p + "입니다.");
				} catch (실습4_5객체원형큐_배열.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 4: // 덤프
				try {
					oq.dump();
				} catch (실습4_5객체원형큐_배열.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;
			default:
				break;
			}
		}
		stdIn.close();
	}
}
