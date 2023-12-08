package ch07ex01;

public class Vehicle {
	private String name;
	private int tire;
	private double height;
	private String fuel;
	String purpose;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTire() {
		return tire;
	}

	public void setTire(int tire) {
		this.tire = tire;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	
	String purpose(double height) {
		if(height >2) {
			purpose = "for business";
		}else {
			purpose = "for private";
		}
		return purpose;
	}
	

	public String toString() {
		return name + " has " + tire + " tires and uses " + fuel + ". Its purpose is "+purpose+".";
	} //왜 purpose가 null인지 모르겠다.
}
