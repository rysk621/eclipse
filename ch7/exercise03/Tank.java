package ch7.exercise03;

public class Tank extends Unit {

	private int v;

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}
	
	@Override
	public String toString() {
		return super.toString()+"\t"+v;
	}
	
}
