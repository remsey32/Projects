import java.awt.Color;
import acm.graphics.*;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: Skyscraper
 * 
 * Program draws a skyscraper using a rects.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */

public class Skyscraper extends GraphicsProgram {
	public static void main(String[] args) {
		new Skyscraper().start(args);
	}
	
	public void run() {
		setSize(350, 650);
		setBackground(Color.DARK_GRAY);

		GRect skyscraper = new GRect(300, 600);
		skyscraper.setColor(Color.BLACK);
		skyscraper.setFilled(true);
		add(skyscraper, 0, 0);

		//GRect windowOne - windowFive: first window row
		GRect windowOne = new GRect(30, 50);
		windowOne.setColor(Color.YELLOW);
		windowOne.setFilled(true);
		add(windowOne, 15, 50);

		GRect windowTwo = new GRect(30, 50);
		windowTwo.setColor(Color.YELLOW);
		windowTwo.setFilled(true);
		add(windowTwo, 60, 50);

		GRect windowThree = new GRect(30, 50);
		windowThree.setColor(Color.YELLOW);
		windowThree.setFilled(true);
		add(windowThree, 105, 50);

		GRect windowFour = new GRect(30, 50);
		windowFour.setColor(Color.YELLOW);
		windowFour.setFilled(true);
		add(windowFour, 155, 50);

		GRect windowFive = new GRect(30, 50);
		windowFive.setColor(Color.YELLOW);
		windowFive.setFilled(true);
		add(windowFive, 255, 50);

		//GRect windowSix - windowSeven: second window row
		GRect windowSix = new GRect(30, 50);
		windowSix.setColor(Color.YELLOW);
		windowSix.setFilled(true);
		add(windowSix, 15, 180);

		GRect windowSeven = new GRect(30, 50);
		windowSeven.setColor(Color.YELLOW);
		windowSeven.setFilled(true);
		add(windowSeven, 105, 180);

		//next window row
		GRect windowEight = new GRect(30, 50);
		windowEight.setColor(Color.YELLOW);
		windowEight.setFilled(true);
		add(windowEight, 155, 245);

		GRect windowNine = new GRect(30, 50);
		windowNine.setColor(Color.YELLOW);
		windowNine.setFilled(true);
		add(windowNine, 255, 245);

		//next window row
		GRect windowTen = new GRect(30, 50);
		windowTen.setColor(Color.YELLOW);
		windowTen.setFilled(true);
		add(windowTen, 15, 310);

		//next window row
		GRect windowEleven = new GRect(30, 50);
		windowEleven.setColor(Color.YELLOW);
		windowEleven.setFilled(true);
		add(windowEleven, 60, 375);

		GRect windowTwelve = new GRect(30, 50);
		windowTwelve.setColor(Color.YELLOW);
		windowTwelve.setFilled(true);
		add(windowTwelve, 205, 375);
	}
}