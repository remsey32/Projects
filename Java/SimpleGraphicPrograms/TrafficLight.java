import java.awt.Color;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: TrafficLight
 * 
 * Draw a traffic light using a rect and ovals.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */

public class TrafficLight extends GraphicsProgram {
	public static void main(String[] args) {
		new TrafficLight().start(args);
	}
	
	public void run() {
		setSize(130, 350);
		GRect box = new GRect(100, 300);
		box.setFilled(true);
		box.setFillColor(Color.BLACK);
		add(box, 0, 0);

		GOval redLamp = new GOval(80, 80);
		redLamp.setColor(Color.RED);
		redLamp.setFilled(true);
		redLamp.setFillColor(Color.RED);
		add(redLamp, 10, 20);

		GOval yellowLamp = new GOval(80, 80);
		yellowLamp.setColor(Color.YELLOW);
		yellowLamp.setFilled(true);
		yellowLamp.setFillColor(Color.YELLOW);
		add(yellowLamp, 10, 110);

		GOval greenLamp = new GOval(80, 80);
		greenLamp.setColor(Color.GREEN);
		greenLamp.setFilled(true);
		greenLamp.setFillColor(Color.GREEN);
		add(greenLamp, 10, 200);
	}
}