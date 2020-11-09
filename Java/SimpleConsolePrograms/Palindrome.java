import java.util.Stack;
import acm.program.ConsoleProgram;

/**
 * Geben Sie ein beliebiges Wort ein. Das Programm wird testen, ob es sich um
 * ein Palindrom handelt.
 * 
 * @author Sven Remy
 */

public class Palindrome_02 extends ConsoleProgram {
	public static void main(String[] args) {
		new Palindrome_02().start(args);
	}

	public void run() {
		setFont("Times New Roman-bold-30");

		String word = readLine("Enter your word:  ");
		boolean check = isPalindrom(word);
		if (check == true) {
			println("Your word is a Palindrom");
		} else {
			println("Your word isn't a Palindrom");
		}
	}

	private boolean isPalindrom(String word) {
		String reverse = "";
		Stack<Character> stapel = new Stack<Character>();
		for (int i = 0; i < word.length(); i++) {
			stapel.push(word.charAt(i));
		}
		for (int i = 0; i < word.length(); i++) {
			reverse += stapel.pop();
		}
		if (reverse.equals(word)) {
			return (true);
		} else {
			return (false);
		}
	}
}