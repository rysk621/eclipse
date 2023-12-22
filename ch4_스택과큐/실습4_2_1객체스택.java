package ch4_스택과큐;

//4장 소스코드의 Point2 버젼을 학습한 후에 Queue 버젼을 구현한다.

import java.util.ArrayList;
import java.util.List;
/*
* objectStack에 Point2 객체를 push, pop하는 코드를 구현 실습한다
*/
import java.util.Random;
import java.util.Scanner;

class Point2 {
	private int ix;
	private int iy;

	public Point2(int x, int y) {
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
//		Object type의 p에 대하여 Point2 type의 this.ix와 비교할 수 없으므로 Point2 type으로 casting 해준다.
		if ((this.ix == ((Point2) p).ix) && (this.iy == ((Point2) p).iy))
			return true;
		else
			return false;
	}
}

class ObjectStack {
	// --- 실행시 예외: 스택이 비어있음 ---//
	// generic class는 Throwable을 상속받을 수 없다 - 지원하지 않는다
	public class EmptyGenericStackException extends Exception {
		private static final long serialVersionUID = 1L;

		public EmptyGenericStackException() {
			super();
		}
	}

	// --- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowGenericStackException extends RuntimeException {
		public OverflowGenericStackException() {
		}
	}

	private List<Point2> data; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

//--- 생성자(constructor) ---//
	public ObjectStack(int capacity) {
		this.capacity = capacity;
		this.top = 0;
		try {
			this.data = new ArrayList<>(this.capacity);
			System.out.println(data.size());
		} catch (OutOfMemoryError e) {
			this.capacity = 0;
		}
	}

//--- 스택에 x를 푸시 ---//
	public boolean push(Point2 x) throws OverflowGenericStackException {
//		Point2 객체 x를 push() method 이용하여 list에 삽입한다.
		if (this.top >= this.capacity)
			throw new OverflowGenericStackException();
		this.data.add(x);
		top++;
		return true;
	}

//--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Point2 pop() throws EmptyGenericStackException {
//		Point2 객체의 List<Point2> data에서 맨 위쪽의 데이터를 pop()
		if (this.top <= 0)
			throw new EmptyGenericStackException();
		return this.data.remove(--this.top); //--top 해줘야함. 주의
	}

//--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Point2 peek() throws EmptyGenericStackException {
		if (this.top <= 0)
			throw new EmptyGenericStackException();
		return this.data.get(top - 1);
	}

//--- 스택을 비움 ---//
	public void clear() {
		top = 0;
	}

//--- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(Point2 x) {
		for (int i = 0; i < top; i++) {
			if (this.data.get(i) == x)
				return i;
		}
		return -1;
	}

//--- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

//--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

//--- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return top <= 0;
	}

//--- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return top >= capacity;
	}

//--- 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력 ---//
	public void dump() {
		if (top <= 0)
			System.out.println("비었습니다.");
		else {
			for (int i = 0; i < top; i++) {
				System.out.print(this.data.get(i) + " ");
			}
			System.out.println();
		}
	}
}

public class 실습4_2_1객체스택 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		ObjectStack s = new ObjectStack(8); // 최대 8개를 push 할 수 있는 stack
		Random random = new Random();
		int rndx = 0, rndy = 0;
		Point2 p = null;
		while (true) {
			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			switch (menu) {
			case 1: // 푸시
				rndx = random.nextInt(20);
				rndy = random.nextInt(20);
				p = new Point2(rndx, rndy);
				try {
					s.push(p);
					System.out.println("push한 데이터는 " + p + "입니다.");
				} catch (ObjectStack.OverflowGenericStackException e) {
					System.out.println("stack이 가득 찼습니다.");
				}
				break;

			case 2: // 팝
				try {
					p = s.pop();
					System.out.println("pop한 데이터는 " + p + "입니다.");
				} catch (ObjectStack.EmptyGenericStackException e) {
					System.out.println("stack이 비어있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = s.peek();
					System.out.println("peek한 데이터는 " + p + "입니다.");
				} catch (ObjectStack.EmptyGenericStackException e) {
					System.out.println("stack이 비어있습니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;
			}
		}
		stdIn.close();
	}
}