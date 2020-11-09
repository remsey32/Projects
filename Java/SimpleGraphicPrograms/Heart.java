import java.awt.Color;
import acm.graphics.GOval;
import acm.graphics.GPolygon;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: Heart
 * 
 * Program draws a heart shape using two ovals and a polygon.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */

public class Heart extends GraphicsProgram {
	public static void main(String[] args) {
		new Heart().start(args);
	}
	
	public void run() {
		GOval circleOne = new GOval(100, 100);
		circleOne.setColor(Color.RED);
		circleOne.setFilled(true);
		circleOne.setFillColor(Color.RED);
		add(circleOne, 0, 0);

		GOval circleTwo = new GOval(100, 100);
		circleTwo.setColor(Color.RED);
		circleTwo.setFilled(true);
		circleTwo.setFillColor(Color.RED);
		add(circleTwo, 100, 0);

		GPolygon poly = new GPolygon();
		poly.addVertex(100, 50);
		poly.addVertex(14, 86);
		poly.addVertex(100, 175);
		poly.addVertex(186, 86);
		poly.setFilled(true);
		poly.setFillColor(Color.RED);
		poly.setColor(Color.RED);
		add(poly, 0, 0);
	}
}