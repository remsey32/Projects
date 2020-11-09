import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: Calculator
 * 
 * A Console program that repeatedly takes two numbers and adds them.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */

public class Calculator extends ConsoleProgram {
	public static void main(String[] args) {
		new Calculator().start(args);
	}

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		while (true) {
			int n1 = readInt("Enter number one: ");
			int n2 = readInt("Enter number two: ");
			int sum = n1 + n2;
			println("The sum is: " + sum);

		}
	}
}