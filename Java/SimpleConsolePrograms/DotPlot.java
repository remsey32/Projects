import acm.graphics.GRect;
import acm.io.IODialog;
import acm.program.GraphicsProgram;

/**
 * Das Programm fragt den Nutzer nach zwei Strings aus denen ein DotPlot erstellt wird.
 * 
 * @author Sven Remy
 */

public class DotPlot extends GraphicsProgram {
	public static void main(String[] args) {
		new DotPlot().start(args);
	}
	
	int BLOCK_SIZE = 50;

	public void run() {
		IODialog dialog = new IODialog();
		String s1 = dialog.readLine("Enter first string:");
		String s2 = dialog.readLine("Enter second string:");
		showSimilarity(s1, s2);
	}

	private void showSimilarity(String s1, String s2) {
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					GRect pixel = new GRect(BLOCK_SIZE, BLOCK_SIZE);
					pixel.setFilled(true);
					add(pixel, i * BLOCK_SIZE, j * BLOCK_SIZE);
				}
			}
		}
	}
}