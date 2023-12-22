package ch4_스택과큐;

/*
 * 교재에 있는 소스코드
 * 입력하여 실행 실습
 * 정수형 스택 소스 코드
 */

import java.util.Scanner;

//int형 고정 길이 스택

class IntStack {
	private int[] stk; // 스택용 배열
	private int capacity; // 스택의 크기
	private int ptr; // 스택 포인터

//--- 실행시 예외: 스택이 비어있음 ---//
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
		}
	}

//--- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
		}
	}

//--- 생성자(constructor) ---//
	public IntStack(int maxlen) {
//		포인터는 0 위치에 초기화한다. capacity는 정수 maxlen을 전달받아 해당 길이만큼의 int[] stk을 생성한다. If 'out of memory error'가 발생시 오류 throw한다.
		ptr = 0;
		capacity = maxlen;
		try {
			stk = new int[capacity];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

//--- 스택에 x를 푸시 ---//
	public int push(int x) throws OverflowIntStackException {
		if (ptr >= capacity)
			throw new OverflowIntStackException();
		return stk[ptr++] = x; // stk[ptr]에 x를 넣고 ptr++
	}

//--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public int pop() throws EmptyIntStackException {
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[--ptr]; // --ptr번째의 stk element를 return.
	}

//--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public int peek() throws EmptyIntStackException {
//		스택이 비어 있으면 Exception throw한다. 스택에 값이 있으면 return한다. (pointer를 기준으로 한다.)
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[ptr - 1];
	}

//--- 스택을 비움 ---//
	public void clear() {
		ptr = 0;
	}

//--- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(int x) {
		for (int i = ptr - 1; i >= 0; i--) {
			if (stk[i] == x)
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
		return ptr;
	}

//--- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return ptr <= 0;
	}

//--- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return ptr >= capacity;
	}

//--- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
	public void dump() {
//		pointer != 0 일 때만 data를 출력해야 함. for (int a : stk)문을 사용하면 빈 array도 0으로 초기화되어 다 출력된다. i를 ptr까지로 제한해야 함.
		if (ptr <= 0)
			System.out.println("빈 스택");
		else {
			for (int i = 0; i < ptr; i++) {
				System.out.print(stk[i] + " ");
			}
			System.out.println();
		}
	}
}

public class 실습4_2정수스택 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntStack s = new IntStack(64); // 최대 64 개를 푸시할 수 있는 스택

		while (true) {
			System.out.println("=".repeat(30)); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(5)index찾기　(0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {
			case 1: // 푸시
				System.out.print("데이터: ");
				x = stdIn.nextInt();
				try {
					s.push(x);
				} catch (IntStack.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;

			case 2: // 팝
				try {
					x = s.pop();
					System.out.println("팝한 데이터는 " + x + "입니다.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;

			case 3: // 피크
				try {
					x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;

			case 5: // indexOf
				if (s.size() != 0) {
					System.out.print("데이터: ");
					x = stdIn.nextInt();
					if (s.indexOf(x) != -1)
						System.out.println(x + "는 s[" + s.indexOf(x) + "]");
					else
						System.out.println("없는 데이터");
				} else
					System.out.println("스택이 비어있습니다.");
			}
		}
		stdIn.close();
	}
}