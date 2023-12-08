package ch6;

public class ThisTest {
	int i = 1;

	public void first() {
		int i = 2;
		int j = 3;
		this.i = i + j; //field값 멤버변수 i를 this.i라고 함

		second(4);
	}

	public void second(int i) { //second(4)가 i에 들어감.
		int j = 5;
		this.i = i + j; //9가 됨.
	}

	public static void main(String[] args) {
		ThisTest exam = new ThisTest();
		exam.first(); //debug 할 때 step into 이용, method 안으로 들어감
	}
}
