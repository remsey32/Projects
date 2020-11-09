import java.awt.Font;
import java.util.Date;
import javax.swing.JLabel;
import acm.program.Program;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Swing: Clock
 * 
 * A Swing program that displays the time in big letters using a JLabel.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */

public class Clock extends Program {
	public static void main(String[] args) {
		new Clock().start(args);
	}
	
	private final int WIDTH = 1400;
	private final int HEIGHT = 200;

	private final int DELAY = 500;

	private JLabel face;

	private Date date;

	public void init() {
		setSize(WIDTH, HEIGHT);
		face = new JLabel();
		face.setFont(new Font("SansSerif", Font.PLAIN, 80));
	}

	public void run() {
		while (true) {
			date = new Date();
			add(face, NORTH);
			face.setText(date.toString());
			remove(face);
			pause(DELAY);
		}
	}
}