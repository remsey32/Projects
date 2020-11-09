import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: ASCII
 * 
 * Print ASCII characters from 32 to 128.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */

public class ASCII extends ConsoleProgram {
	public static void main(String[] args) {
		new ASCII().start(args);
	}

	public void run() {
		setSize(1100, 150);
		setFont("monospaced-18");

		isUpperCase();
		toUpperCase();
		printASCIITable();
	}

	private void printASCIITable() {
		for (int i = 33; i < 128; i++) {
			char ascii = (char) i;
			print(ascii);
		}
	}

	private void isUpperCase() {
		char c = 'c';
		if (c >= 'A' && c <= 'Z') {
			println(c + " is uppercase!");
		} else {
			println(c + " is no uppercase");
		}
	}

	private void toUpperCase() {
		char klein = 'a';
		char gross = (char) (klein - 'a' + 'A');
		println(gross);
	}
}