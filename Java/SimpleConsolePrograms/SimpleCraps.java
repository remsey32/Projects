import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: SimpleCraps
 * 
 * Craps is a dice game in which the players make wagers on the outcome of the
 * roll, or a series of rolls, of a pair of dice. In SimpleCraps we have the
 * following bets: <br/>
 * - (exact match (number)) <br/>
 * - odd <br/>
 * - even <br/>
 * - high (4,5,6) <br/>
 * - low (1,2,3) <br/>
 * 
 * @see https://en.wikipedia.org/wiki/Craps
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */

public class SimpleCraps extends ConsoleProgram {
	public static void main(String[] args) {
		new SimpleCraps().start(args);
	}
	
// constants
	private int STARTING_MONEY = 100;
	private final int WAGER_AMOUNT = 10;

// instance variables
	private RandomGenerator rgen = new RandomGenerator();

	public void run() {
		setSize(400, 400);
		setFont("Times New Roman-bold-20");

		for (int i = STARTING_MONEY; i > 0; i++) {
			println("You have " + STARTING_MONEY + "€");

			String bet = readLine("Enter your bet: ");

			int diceNumber = rgen.nextInt(1, 6);
			println("The dice shows " + diceNumber + ".");

			winOrLose(bet, diceNumber);
		}
	}

	private void winOrLose(String bet, int diceNumber) {
		if (bet.equals("odd")) {
			if (diceNumber == 1 || diceNumber == 3 || diceNumber == 5) {
				println("You win!");
				STARTING_MONEY = STARTING_MONEY + WAGER_AMOUNT;
			} else {
				println("You lose!");
				STARTING_MONEY = STARTING_MONEY - WAGER_AMOUNT;
			}
		}
		if (bet.equals("even")) {
			if (diceNumber == 2 || diceNumber == 4 || diceNumber == 6) {
				println("You win!");
				STARTING_MONEY = STARTING_MONEY + WAGER_AMOUNT;
			} else {
				println("You lose!");
				STARTING_MONEY = STARTING_MONEY - WAGER_AMOUNT;
			}
		}
		if (bet.equals("high")) {
			if (diceNumber == 4 || diceNumber == 5 || diceNumber == 6) {
				println("You win!");
				STARTING_MONEY = STARTING_MONEY + WAGER_AMOUNT;
			} else {
				println("You lose!");
				STARTING_MONEY = STARTING_MONEY - WAGER_AMOUNT;
			}
		}
		if (bet.equals("low")) {
			if (diceNumber == 1 || diceNumber == 2 || diceNumber == 3) {
				println("You win!");
				STARTING_MONEY = STARTING_MONEY + WAGER_AMOUNT;
			} else {
				println("You lose!");
				STARTING_MONEY = STARTING_MONEY - WAGER_AMOUNT;
			}
		}
	}
}