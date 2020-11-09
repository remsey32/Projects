import java.awt.Color;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: Piano
 * 
 * Program draws the keys of a piano.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */
public class Piano extends GraphicsProgram {
	public static void main(String[] args) {
		new Piano().start(args);
	}
	
	public void run() {
		GRect noteF = new GRect(50, 200);
		add(noteF, 0, 0);

		GRect noteG = new GRect(50, 200);
		add(noteG, 50, 0);

		GRect noteA = new GRect(50, 200);
		add(noteA, 100, 0);

		GRect noteH = new GRect(50, 200);
		add(noteH, 150, 0);

		GRect noteC = new GRect(50, 200);
		add(noteC, 200, 0);

		GRect noteD = new GRect(50, 200);
		add(noteD, 250, 0);

		GRect noteE = new GRect(50, 200);
		add(noteE, 300, 0);

		GRect noteFis = new GRect(30, 130);
		noteFis.setFilled(true);
		noteFis.setFillColor(Color.BLACK);
		add(noteFis, 35, 0);

		GRect noteGis = new GRect(30, 130);
		noteGis.setFilled(true);
		noteGis.setFillColor(Color.BLACK);
		add(noteGis, 85, 0);

		GRect noteAis = new GRect(30, 130);
		noteAis.setFilled(true);
		noteAis.setFillColor(Color.BLACK);
		add(noteAis, 135, 0);

		GRect noteCis = new GRect(30, 130);
		noteCis.setFilled(true);
		noteCis.setFillColor(Color.BLACK);
		add(noteCis, 235, 0);

		GRect noteDis = new GRect(30, 130);
		noteDis.setFilled(true);
		noteDis.setFillColor(Color.BLACK);
		add(noteDis, 285, 0);
	}
}