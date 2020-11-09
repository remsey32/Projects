import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: YearlyRate
 * 
 * A Console program that calculates your yearly rate on a loan, given credit
 * amount, length of loan and interest rate.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */

public class YearlyRate extends ConsoleProgram {
	public static void main(String[] args) {
		new YearlyRate().start(args);
	}

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-24");

		int k = readInt("Enter credit amount: ");
		int n = readInt("Enter how many years: ");
		double z = readDouble("Enter interest rate: ");
		double q = 1.0 + z;
		double qn = Math.pow(q, n); // q^n;
		double y = (k * qn * (q - 1)) / (qn - 1);
		println("Yearly rate is: " + y + "€");
	}
}