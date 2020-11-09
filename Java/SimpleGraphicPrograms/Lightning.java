import acm.graphics.GLine;
import acm.program.GraphicsProgram;

/**
 * Ein schönes kleines Programm, dass ein paar zufällig generierte Blitze zwischen zwei
 * Punkten herstellt.
 * 
 * @author Sven Remy
 */

public class Lightning extends GraphicsProgram {
	public static void main(String[] args) {
		new Lightning().start(args);
	}

	public void run() {
		double linkPunktx = 10;
		double linkerPunkty = 250;
		double rechterPunktx = 500;
		double rechterPunkty = 250;
		double displace = 200;
		for (int i = 0; i < 4; i++) {
		drawLightning(linkPunktx, linkerPunkty, rechterPunktx, rechterPunkty, displace);
		}
	}

	private void drawLightning(double x1, double y1, double x2, double y2, double displace) {
		
		// base case
		if (displace < 2) {
			drawLine(x1, y1, x2, y2);
			
		// recursive case
		} else {
			double mid_x = (x2 + x1) / 2.0;
			double mid_y = (y2 + y1) / 2.0;
			mid_x += (Math.random() - 0.5) * displace;
			mid_y += (Math.random() - 0.5) * displace;
			drawLightning(x1, y1, mid_x, mid_y, displace / 2);
			drawLightning(x2, y2, mid_x, mid_y, displace / 2);
		}
	}

	private void drawLine(double x1, double y1, double x2, double y2) {
		GLine blitz = new GLine(x1, y1, x2, y2);
		add(blitz);
	}
}