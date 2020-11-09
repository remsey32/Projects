import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: Countdown
 * 
 * A Console program that counts down from 10 to 0 and prints the values to the
 * console.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */

public class Countdown extends ConsoleProgram {
	public static void main(String[] args) {
		new Countdown().start(args);
	}

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-24");

		int i = 10;
		while (i > -1) {
			println(i);
			i = i - 1;
		}
		println("Start");
	}
}