import java.awt.Color;
import acm.graphics.GPolygon;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: SpaceShip
 * 
 * Draw a space ship using a polygon.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */

public class Spaceship extends GraphicsProgram {
	public static void main(String[] args) {
		new Spaceship().start(args);
	}
	
	public void run() {
		setSize(300, 300);
		GPolygon poly = new GPolygon();
		poly.addVertex(100, 10);
		poly.addVertex(30, 210);
		poly.addVertex(100, 150);
		poly.addVertex(170, 210);
		poly.setColor(Color.BLACK);
		add(poly, 0, 0);
	}
}