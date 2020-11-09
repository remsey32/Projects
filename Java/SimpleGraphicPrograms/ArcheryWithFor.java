import java.awt.Color;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: 1. Archery
 * 
 * Program draws a target using three ovals.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */

public class ArcheryWithFor extends GraphicsProgram {
	public static void main(String[] args) {
		new ArcheryWithFor().start(args);
	}

	public void run() {
		setSize(700, 700);
		int NR_RINGS = 10;
		int r = NR_RINGS * 30;

		for (int i = 0; i < NR_RINGS; i++) {
			if (i % 2 == 0) {
				drawCircle(r, Color.RED);
			} else {
				drawCircle(r, Color.WHITE);

			}
			r = r - 30;
		}

	}

	private void drawCircle(int radius, Color color) {
		GOval ring = new GOval(2 * radius, 2 * radius);
		ring.setColor(color);
		ring.setFilled(true);
		int x = 200 + 72 - radius;
		add(ring, x, x);

	}
}