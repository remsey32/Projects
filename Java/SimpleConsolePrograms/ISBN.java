import acm.program.ConsoleProgram;

/**
 * Internationale Standardbuchnummer eingeben und prüfen lassen
 * 
 * @author Sven Remy
 */

public class ISBN_02 extends ConsoleProgram {
	public static void main(String[] args) {
		new ISBN_02().start(args);
	}

	public void run() {
		setFont("Times New Roman-bold-30");

		String isbn = readLine("Enter your ISBN: ");
		boolean check = checkNumber(isbn);
		if (check == true) {
			println("Number is correct");
		} else {
			println("Number is not correct");
		}
	}

	private boolean checkNumber(String isbn) { 
		int sum = 0;
		int len = isbn.length();
		if (isbn.charAt(9) == 'X') {
			for (int j = 0; j < (len - 1); j++) {
				int x = isbn.charAt(j) - '0';
				sum += x * (j + 1);
			}
			sum += 10 * 10;
		} else {
			for (int i = 0; i < len; i++) {
				int x = isbn.charAt(i) - '0';
				sum += x * (i + 1);
			}
		}
		return sum % 11 == 0;
	}
}