package ch7interface;

public interface Messenger {
	public static final int MIN_SIZE = 1;
	public static final int MAX_SIZE = 104857600; // public static final은 안 붙여도 자동으로 컴파일시 작성해줌.

	public abstract String getMessage();

	public abstract void setMessage(String msg); // getter-setter 이용하여 인터페이스 정의

	public default void setLogin(boolean login) {
		log();
		if (login) {
			System.out.println("로그인 처리합니다.");
		} else {
			System.out.println("로그아웃 처리합니다.");
		}
	}

	public static void getConnection() {
		System.out.println("network에 연결합니다.");
	}

	private void log() {
		System.out.println("start job!");
	}
}
