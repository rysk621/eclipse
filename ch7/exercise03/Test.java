package ch7.exercise03;

public class Test {
	public static void main(String[] args) {
		Marine m = new Marine();
		Tank t = new Tank();
		
		m.setName("Marine");
		m.setHealth(100L);
		m.setDd(500);
		t.setName("Tank");
		t.setHealth(1000L);
		t.setV(5);
		
		System.out.println(m.toString());
		System.out.println(t.toString());
	}
}
