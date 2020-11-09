import acm.program.ConsoleProgram;
import java.util.Stack;

/**
 * Klammern eingeben und testen lassen ob es für jede geöffnete KLammer eine
 * dazu passende schließende KLammer gibt.
 * 
 * @author Sven Remy
 */

public class Parentheses_02 extends ConsoleProgram {
	public static void main(String[] args) {
		new Parentheses_02().start(args);
	}

	public void run() {
		setFont("Times New Roman-bold-30");

		String brackets = readLine("Enter some brackets: ");
		boolean check = doParenthesesMatch(brackets);
		if (check == true) {
			println("brackets matching");
		} else {
			println("brackets do not matching");
		}
	}

	private boolean doParenthesesMatch(String brackets) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < brackets.length(); i++) {
			char c = brackets.charAt(i);
			switch (c) {

			// checking -> ( and )
			case '(':
				stack.push(c);
				break;
			case ')':
				if (!stack.isEmpty()) {
					stack.pop();
				} else {
					return false;
				}
				break;

			// checking -> { and }
			case '{':
				stack.push(c);
				break;
			case '}':
				if (!stack.isEmpty()) {
					stack.pop();
				} else {
					return false;
				}
				break;

			// checking -> [ and ]
			case '[':
				stack.push(c);
				break;
			case ']':
				if (!stack.isEmpty()) {
					stack.pop();
				} else {
					return false;
				}
				break;

			// if something is wrong
			default:
				System.out.println("we should never get here!");
				break;
			}
		}
		// if parenthesis matching
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}
}