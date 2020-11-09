import acm.program.ConsoleProgram;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Geben Sie einen beliebigen Satz ein. Das Programm wird die Schlüsselwörter,
 * die für ein perfektes Suchergebnis nötig sind herausfiltern.
 * 
 * @author Sven Remy
 */

public class StopWords extends ConsoleProgram {
	public static void main(String[] args) {
		new StopWords().start(args);
	}

	public void run() {
		setFont("Times New Roman-bold-30");

		HashSet<String> textToSet = textToSetMethode("StopWords.txt");

		String sentence = readLine("Enter your sentence: ");
		String finalSentence = removeStopWords(sentence, textToSet);
		println(finalSentence);
	}

	private HashSet<String> textToSetMethode(String stopWords) {
		HashSet<String> textToString = new HashSet<String>();
		try {
			FileReader fr = new FileReader("StopWords.txt");
			BufferedReader br = new BufferedReader(fr);
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				StringTokenizer toki = new StringTokenizer(line, " ");
				while (toki.hasMoreTokens()) {
					String sw = toki.nextToken().trim().toLowerCase();
					textToString.add(sw);
				}
			}
			br.close();
			fr.close();
		} catch (Exception ex) {
			println("error");
		}
		return (textToString);
	}

	private String removeStopWords(String sentence, HashSet<String> textToSet) {
		String finalSentence = "";
		StringTokenizer toki = new StringTokenizer(sentence);
		while (toki.hasMoreTokens()) {
			String word = toki.nextToken().toLowerCase();
			if (!textToSet.contains(word)) {
				finalSentence += word + " ";
			}
		}
		return (finalSentence);
	}
}