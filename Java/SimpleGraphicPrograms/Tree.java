import acm.graphics.GLine;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * Ein schönes kleines Programm, dass einen zufälligen bunten Baum generiert.
 * 
 * @author Sven Remy
 */

public class Tree extends GraphicsProgram {
	public static void main(String[] args) {
		new Tree().start(args);
	}
	RandomGenerator rgen = new RandomGenerator();
	
	public void run() {
		setSize(800, 750);
		double x1 = 250.0;
		double y1 = 700.0;
		double angle = 90.0;
		double length = 200;
		
		drawBranch (x1, y1, angle, length);
	}

	private void drawBranch(double x1, double y1, double angle, double length) {
		
		double x2 = x1 - Math.cos(angle) * length;
		double y2 = y1 - Math.sin(angle) * length;
		drawLine(x1, y1, x2, y2, length);
		
		// base case
		if (length < 10)
		return;
		
		// recursive case
		double bendAngle = Math.toRadians(rgen.nextDouble(-10, 10));
		double branchAngle = Math.toRadians(rgen.nextDouble(-30, 30));
		drawBranch(x2, y2, angle + bendAngle - branchAngle,
		length * rgen.nextDouble(0.6, 0.8));
		drawBranch(x2, y2, angle + bendAngle + branchAngle,
		length * rgen.nextDouble(0.6, 0.8));
		}

	private void drawLine(double x1, double y1, double x2, double y2, double length) {
		GLine ast = new GLine (x1, y1, x2, y2);
		ast.setColor(rgen.nextColor());
		add (ast);
	}
}