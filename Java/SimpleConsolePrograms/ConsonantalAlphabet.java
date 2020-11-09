import acm.program.ConsoleProgram;

/**
 * Beliebiger Satz (String) wird in Konsonantenschrift übersetzen.
 * 
 * @author Sven Remy
 */

public class ConsonantalAlphabet_01 extends ConsoleProgram {
	public static void main(String[] args) {
		new ConsonantalAlphabet_01().start(args);
	}

	public void run() {
		setFont("Times New Roman-bold-30");

		String sentence = readLine("Enter your sentence: ");
		String translated = translate(sentence);
		print(translated);
	}

	private String translate(String sentence) {
		String nowals = ""; // nowals = no Vowals
		for (int i = 0; i < sentence.length(); i++) {
			if (!isVowel(sentence.charAt(i))) {
				nowals += sentence.charAt(i);
			}
		}
		return nowals;
	}

	private boolean isVowel(char letter) {
		if ("aeiouAEIOU".indexOf(letter) > -1) {
			return true;
		} else {
			return false;
		}
	}
}