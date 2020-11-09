import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: LeapYear
 * 
 * Ask the user to enter a year and find out if a give year is a leap year.
 * Simply use the method provided. Try to understand how it works.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */

public class LeapYear extends ConsoleProgram {
	public static void main(String[] args) {
		new LeapYear().start(args);
	}

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-24");

		int birthYear = readInt("Enter your year of birth: ");
		boolean n1 = ((birthYear % 4 == 0) && (birthYear % 100 != 0)) || (birthYear % 400 == 0);
		if (n1 == true) {
			println("The year you were born was a leap year.");
		} else {
			println("The year you was born was not leap year.");
		}
	}
}