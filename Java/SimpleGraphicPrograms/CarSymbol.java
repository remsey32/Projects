import java.awt.Color;
import acm.graphics.GOval;
import acm.graphics.GPolygon;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: CarSymbol
 * 
 * For your favorite car, write a graphics program that draws the symbol of that
 * car. If that one would be to complicated, pick the symbol for your
 * next-to-favorite car. You will get extra credit, if it happens to be a German
 * car manufacturer.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */

public class CarSymbol extends GraphicsProgram {
	public static void main(String[] args) {
		new CarSymbol().start(args);
	}
	
	public void run() {
		setSize(500, 500);
		GOval mercedesOne = new GOval(255, 255);
		mercedesOne.setColor(Color.BLACK);
		mercedesOne.setFilled(true);
		mercedesOne.setFillColor(Color.BLACK);
		add(mercedesOne, 72, 65);

		GOval mercedesTwo = new GOval(230, 230);
		mercedesTwo.setColor(Color.WHITE);
		mercedesTwo.setFilled(true);
		mercedesTwo.setFillColor(Color.WHITE);
		add(mercedesTwo, 84.5, 77.5);

		GPolygon starOne = new GPolygon();
		starOne.addVertex(0, 0);
		starOne.addVertex(-100, 50);
		starOne.addVertex(-10, -15);
		starOne.addVertex(0, -125);
		starOne.addVertex(10, -15);
		starOne.addVertex(100, 50);
		starOne.setColor(Color.BLACK);
		starOne.setFilled(true);
		starOne.setFillColor(Color.BLACK);
		add(starOne, 200, 200);
	}
}