package ch3;

public class TimesTable_while {

	public static void main(String[] args) {
		int i = 1;
		while (i < 10) {
			int j = 1;
			while (j < 10) {
				System.out.print(i + "*" + j + "=" + i * j + " ");
				j++;
			}
			i++;
			System.out.println("\n");
		}
	}
}
