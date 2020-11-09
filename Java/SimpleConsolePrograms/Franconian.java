import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 *
 * MindReader: Franconian
 *
 * Translate from German to Franconian.
 *
 * @see Dialekte in Bayern - Handreichung fÃ¼r den Unterricht,
 *      www.km.bayern.de/download/12707_broschuere_dialekt_2013_k.pdf
 *
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */

public class Franconian extends ConsoleProgram {
	public static void main(String[] args) {
		new Franconian().start(args);
	}

	char t = 't';

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		String german = readLine("Enter german text: ");
		String franconian = translateGermanToFranconian(german);
		println(franconian);
	}

	private String translateGermanToFranconian(String german) {
		String franconian = "";
		for (int i = 0; i < german.length(); i++) {
			char c = german.charAt(i);
			franconian += charSwitch(c);
		}
		return franconian;
	}

	private char charSwitch(char c) {
		switch (c) {
		case 't':
			return 'd';
		case 'k':
			return 'g';
		case 'p':
			return 'b';
		default:
			return c;
		}
	}
}