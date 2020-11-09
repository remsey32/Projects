import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: Money
 * 
 * A Console program that takes an amount in cents, and outputs it in euros and
 * cents. Test it with the following entries: 120, 90, 100, 102, 002.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */

public class Money extends ConsoleProgram {
	public static void main(String[] args) {
		new Money().start(args);
	}
	
	private final int MAX_NUM = 10;

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		int money = readInt("Enter amount in cents: ");
		int euros = money / 100;
		int cents = money % 100;
		if (cents < 10) {
			println("The amount in euro is : " + euros + "," + "0" + cents + "€");
		} else {
			println("The amount in euro is : " + euros + "," + cents + "€");
		}
	}
}