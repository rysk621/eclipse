package ch7.exercise03;

public class Marine extends Unit {
	private int dd;

	public int getDd() {
		return dd;
	}

	public void setDd(int dd) {
		this.dd = dd;
	}
	
	@Override
	public String toString() {
		return super.toString()+"\t"+dd;
	}
}
