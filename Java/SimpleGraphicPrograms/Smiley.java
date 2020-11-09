import java.awt.Color;
import acm.graphics.GArc;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: Smiley
 * 
 * Program draws a simple Smiley that uses GRect, GOval, GLine and also GArc.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */

public class Smiley extends GraphicsProgram {
	public static void main(String[] args) {
		new Smiley().start(args);
	}
	
	public void run() {
		setSize(500, 500);
		GOval face = new GOval(300, 300);
		face.setColor(Color.YELLOW);
		face.setFilled(true);
		face.setFillColor(Color.YELLOW);
		add(face, 0, 0);

		GOval leftEye = new GOval(30, 30);
		leftEye.setColor(Color.BLACK);
		leftEye.setFilled(true);
		leftEye.setFillColor(Color.BLACK);
		add(leftEye, 70, 100);

		GOval rightEye = new GOval(30, 30);
		rightEye.setColor(Color.BLACK);
		rightEye.setFilled(true);
		rightEye.setFillColor(Color.BLACK);
		add(rightEye, 200, 100);

		GArc archie = new GArc(150, 150, 180, 180);
		archie.setColor(Color.BLACK);
		archie.setFilled(true);
		archie.setFillColor(Color.BLACK);
		add(archie, 77, 110);
	}
}