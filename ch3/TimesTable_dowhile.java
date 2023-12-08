package ch3;

public class TimesTable_dowhile {

	public static void main(String[] args) {
		int i = 1;
		do {
			int j = 1;
			do {
				System.out.print(i + "*" + j + "=" + i * j + " ");
				j++;
				
			} while (j < 10);
			i++;
			System.out.println("\n");
		} while (i < 10);
	}
}
