import java.awt.Color;
import java.awt.event.MouseEvent;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 *
 * Agrar: Breakout A simple version of the Breakout game.
 *
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */

public class Breakout extends GraphicsProgram {
	public static void main(String[] args) {
		new Breakout().start(args);
	}
	
// instance variables
	private GOval ball;
	private GRect paddle;
	private GRect bricks;
	private GLabel breakoutLabel;
	private GLabel counter;
	private GLabel gameOver;
	private GLabel points;

// window:
	private static final int WINDOW_WIDTH = 516;
	private static final int WINDOW_HEIGHT = 760;
	private static final int TASKBAR = 30;

// breakoutLabel:
	private static final int X_POSITION_BO = 200;
	private static final int Y_POSITION_BO = 20;

// points:
	private static int POINTS_NR = 0;
	private static final int X_POSITION_P = 380;
	private static final int Y_POSITION_P = 20;

// counter:
	private static int COIN_NR = 3;
	private static final int X_POSITION_C = 10;
	private static final int Y_POSITION_C = 20;

// gameOver:
	private static final int X_POSITION_GO = 10;
	private static final int Y_POSITION_GO = 400;

// ball:
	private static final int X_START_POSITION_B = 250;
	private static final int Y_START_POSITION_B = 620;
	private static final int BALL_WIDTH = 20;
	private static final int BALL_HEIGHT = 20;
	private static final int X_SPEED = 10;
	private static final int Y_SPEED = -7;
	private static int vx = X_SPEED;
	private static int vy = Y_SPEED;

// paddle:
	private static final int X_START_POSITION_PAD = 250;
	private static final int Y_START_POSITION_PAD = 650;
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;
	private static final int PADDLE_LOCATION = 650;

// wall:
	private static final int NR_OF_ROWS = 5;
	private static final int NR_OF_BRICKS_Per_Row = 10;
	private static final int BRICK_WIDTH = 50;
	private static final int BRICK_HEIGHT = 20;

	public void run() {
		setup();

// GameLoop
		while (true) {
			moveBall();
			checkForCollision();
			pause(40);
		}
	}

	private void setup() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		setBackground(Color.LIGHT_GRAY);

		addMouseListeners();

		createBreakoutLabel();
		createPoints();
		createCounter();
		createGameOver();
		createBall();
		createPaddle();
		createBricks();
	}

	private void createBreakoutLabel() {
		breakoutLabel = new GLabel("BREAKOUT");
		breakoutLabel.setFont("SansSerif-20");
		add(breakoutLabel, X_POSITION_BO, Y_POSITION_BO);
	}

	private void createPoints() {
		points = new GLabel("Points: " + POINTS_NR);
		points.setFont("SANSSERIF-20");
		add(points, X_POSITION_P, Y_POSITION_P);
	}

	private void createCounter() {
		counter = new GLabel("Coins: " + COIN_NR);
		counter.setFont("SansSerif-20");
		add(counter, X_POSITION_C, Y_POSITION_C);
	}

	private void createGameOver() {
		RandomGenerator rgen = new RandomGenerator();
		gameOver = new GLabel("GAME OVER");
		gameOver.setFont("SansSerif-80");
		gameOver.setColor(rgen.nextColor());
	}

	private void createBall() {
		ball = new GOval(BALL_WIDTH, BALL_HEIGHT);
		ball.setColor(Color.BLACK);
		ball.setFilled(true);
		ball.setFillColor(Color.RED);
		add(ball, X_START_POSITION_B, Y_START_POSITION_B);
	}

	private void createPaddle() {
		paddle = new GRect(PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		paddle.setFillColor(Color.BLACK);
		add(paddle, X_START_POSITION_PAD, Y_START_POSITION_PAD);
	}

	private void createBricks() {
		int y = TASKBAR;
		for (int j = 0; j < NR_OF_ROWS; j++) {
			drawOneRowOfBricks(y);
			y = y + BRICK_HEIGHT;
		}
	}

	private void drawOneRowOfBricks(int y) {
		int x = 0;
		RandomGenerator rgen = new RandomGenerator();
		for (int i = 0; i < NR_OF_BRICKS_Per_Row; i++) {
			bricks = new GRect(BRICK_WIDTH, BRICK_HEIGHT);
			bricks.setFilled(true);
			bricks.setFillColor(rgen.nextColor());
			add(bricks, x, y);
			x = x + BRICK_WIDTH;
		}
	}

	private void moveBall() {
		ball.move(vx, vy);
	}

	private void checkForCollision() {
		checkForCollisionWithWindow();
		checkForCollisionWithPaddleOrBrick();
		checkForCollisionWithBallTop();
		checkForGameOverCollision();
	}

	private void checkForCollisionWithWindow() {
		double x = ball.getX();
		double y = ball.getY();
		if ((x < 0) || (x > WINDOW_WIDTH - BALL_WIDTH)) {
			vx = -vx;
		}
		if (y < TASKBAR) {
			vy = -vy;
		}
	}

	private void checkForCollisionWithPaddleOrBrick() {
		double x = ball.getX();
		double y = ball.getY();
		GObject obj = getElementAt(x + BALL_WIDTH, y + BALL_HEIGHT);
		if (obj != null && obj != ball && obj != counter) {
			if (obj != paddle) {
				remove(obj);
			}
			vy = -vy;
		}
	}

	private void checkForCollisionWithBallTop() {
		double x = ball.getX();
		double y = ball.getY();
		GObject obj = getElementAt(x, y);
		if (obj != null && obj != ball && obj != counter) {
			if (obj != paddle) {
				remove(obj);
				remove(points);
				POINTS_NR = POINTS_NR + 100;
				createPoints();
			}
			vy = -vy;
		}
	}

	private void checkForGameOverCollision() {
		double y = ball.getY();
		if (y == WINDOW_HEIGHT && COIN_NR == 0) {
			add(gameOver, X_POSITION_GO, Y_POSITION_GO);
			remove(ball);
		}
		if (y == WINDOW_HEIGHT && COIN_NR > 0) {
			remove(counter);
			COIN_NR = COIN_NR - 1;
			createCounter();
			add(ball, X_START_POSITION_B, Y_START_POSITION_B);
			vx = 0;
			vy = 0;
		}
	}

	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		paddle.setLocation(x, PADDLE_LOCATION);
	}

	public void mousePressed(MouseEvent e) {
		vx = X_SPEED;
		vy = Y_SPEED;
	}
}