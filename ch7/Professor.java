package ch7;

public class Professor extends Person {
	private String subject;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return super.getAge() + " : " + subject; // super.toString();
	}
	
	public Professor() {
		System.out.println("Professor 생성자 실행");
	}
}
