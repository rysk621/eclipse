package ch7.exercise03;

public class Unit {
	public Unit() {
	}
	
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Long health;
	
	public Unit(Long health) {
		this.health = health;
	}

	public Long getHealth() {
		return health;
	}

	public void setHealth(Long health) {
		this.health = health;
	}
	public String toString() {
		return name + " : " + health;
	}

}