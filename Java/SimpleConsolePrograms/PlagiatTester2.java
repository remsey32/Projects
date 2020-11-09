import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import acm.program.ConsoleProgram;

/**
 * Console: T5 Renaming
 * 
 * Ein Programm das mithilfe des Longest Common Subsequence Algorithmus und den
 * Separation Chars den Aufbau und die Struktur eines Dokumentes auf Plagiate überprüft.
 * 
 * @author Sven Remy
 */

public class T5 extends ConsoleProgram {
	public static void main(String[] args) {
		new T5().start(args);
	}

	private final String SEPARATION_CHARS = " \n+-*/=<>.;[](){}";

	public void run() {
		String fn = readLine("Welcher Ordner soll geöffnet werden? (z.B. 'files'): ");

		File dir = new File(fn);
		File[] files = dir.listFiles();

		compare(files);
	}

	// gibt die Ähnlichkeit der Struktur, der files in Prozent aus
	private void compare(File[] files) {
		for (int i = 0; i < files.length; i++) {
			for (int j = 0; j < files.length; j++) {
				String s1 = prepareCode(fileToString(files[i]));
				String s2 = prepareCode(fileToString(files[j]));

				float lcs = lcs(s1, s2);
				println("Die folgenden files werden miteinander verglichen: " + files[i].getName() + " <-> " + files[j].getName());

				if (s1.length() < s2.length()) {
					float prozent1 = lcs / s1.length() * 100;
					println("Die Struktur der beiden files hat eine Übereinstimmung von: " + prozent1 + "%\n");
				} else {
					float prozent2 = lcs / s2.length() * 100;
					println("Die Struktur der beiden files hat eine Übereinstimmung von: " + prozent2 + "%\n");
				}
			}
		}
	}

	// konvertiert ein File zu einem String
	private String fileToString(File files) {
		String stringFiles = "";
		try {
			FileReader fr = new FileReader(files);
			BufferedReader br = new BufferedReader(fr);
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				stringFiles += "\n" + line;
			}
			br.close();
			fr.close();

		} catch (Exception ex) {
			println("error");
		}
		return (stringFiles);
	}

	// longest common subsquence
		// @see GeeksForGeeks (online), Java Program for Longest Common Subsequence
		//      Verfügbar unter:
		//      https://www.geeksforgeeks.org/java-program-for-longest-common-subsequence/
		//		Zugriff am: 29.07.2020
	private int lcs(String s1, String s2) {
		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		int L[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (X[i - 1] == Y[j - 1])
					L[i][j] = L[i - 1][j - 1] + 1;
				else
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
			}
		}
		return L[m][n];
	}

	// reduziert den Code auf die separation chars
	// @see Prof.Dr.(USA) Ralph Lano, "T5 Renaming", Studienarbeit: Plagiatserkennung,
	//		S. 3-4, 2020
	private String prepareCode(String s1) {
		StringTokenizer st = new StringTokenizer(s1, SEPARATION_CHARS, true);
		StringBuffer sb = new StringBuffer();
		while (st.hasMoreTokens()) {
			String toki = st.nextToken();
			if (SEPARATION_CHARS.contains(toki)) {
				sb.append(toki);
			} else {
				sb.append("_");
			}
		}
		return sb.toString();
	}
}