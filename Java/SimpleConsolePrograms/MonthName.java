import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: 1. MonthName
 * 
 * A simple ConsoleProgram that swaps two entries in an array of int.
 * 
 * @see Music and mathematics,
 *      en.wikipedia.org/wiki/Mathematics_of_musical_scales
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */

public class MonthName extends ConsoleProgram {
	public static void main(String[] args) {
		new MonthName().start(args);
	}

	private String[] monthName = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		int monthNumber = readInt("Enter Number of Month: ");
		println("The month you mean is: " + monthName[monthNumber - 1]);
	}
}