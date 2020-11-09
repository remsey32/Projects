import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: EvenOdd
 * 
 * A Console program that prints the numbers 0 through 10, and prints if the
 * number is even or odd.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */

public class EvenOdd extends ConsoleProgram {
	public static void main(String[] args) {
		new EvenOdd().start(args);
	}
	
	private final int MAX_NUM = 10;

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		println("even or odd?");
		int n1 = readInt("number: ");
		int rest = n1 % 2;
		println("%2: " + rest);
		if (rest == 1) {
			println("= odd");
		} else {
			println("= even");
		}
	}
}