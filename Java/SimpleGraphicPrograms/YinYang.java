import java.awt.Color;
import acm.graphics.GArc;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: YinYang
 * 
 * Program draws the YinYang Symbol.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */

public class YinYang extends GraphicsProgram {
	public static void main(String[] args) {
		new YinYang().start(args);
	}
	
	public void run() {
		setSize(310, 330);

		GOval bigCircle = new GOval(300, 300);
		add(bigCircle, 0, 0);

		GArc blackHalfCircle = new GArc(300, 300, 270, 180);
		blackHalfCircle.setColor(Color.BLACK);
		blackHalfCircle.setFilled(true);
		blackHalfCircle.setFillColor(Color.BLACK);
		add(blackHalfCircle, 0, 0);

		GArc archieOne = new GArc(150, 150, 270, 180);
		archieOne.setColor(Color.WHITE);
		archieOne.setFilled(true);
		archieOne.setFillColor(Color.WHITE);
		add(archieOne, 60, 0);

		GArc archieTwo = new GArc(150, 150, 90, 180);
		archieTwo.setColor(Color.BLACK);
		archieTwo.setFilled(true);
		archieTwo.setFillColor(Color.BLACK);
		add(archieTwo, 80, 150);

		GOval smallBlackCircle = new GOval(30, 30);
		smallBlackCircle.setColor(Color.BLACK);
		smallBlackCircle.setFilled(true);
		smallBlackCircle.setFillColor(Color.BLACK);
		add(smallBlackCircle, 135, 60);

		GOval smallWhiteCircle = new GOval(30, 30);
		smallWhiteCircle.setColor(Color.WHITE);
		smallWhiteCircle.setFilled(true);
		smallWhiteCircle.setFillColor(Color.WHITE);
		add(smallWhiteCircle, 135, 210);
	}
}