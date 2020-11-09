import java.awt.Color;
import java.awt.event.KeyEvent;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: Pong
 * 
 * A simple version of the game of Pong, a little like ping-pong.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */

public class Pong extends GraphicsProgram {
	public static void main(String[] args) {
		new Pong().start(args);
	}
	
// instance variables
	private GOval ball;
	private GRect leftPaddle;
	private GRect rightPaddle;
	private GLabel pong;
	private GLabel winnerLeft;
	private GLabel winnerRight;

// window
	private final int WIDTH = 600;
	private final int HEIGHT = 400;
	private final int DELAY = 20;

// labels
	private final int PONG_X = 70;
	private final int PONG_Y = 220;

	private final int WINNER_LEFT_X = 70;
	private final int WINNER_LEFT_Y = 180;

	private final int WINNER_RIGHT_X = 60;
	private final int WINNER_RIGHT_Y = 180;

// ball
	private final int BALL_SIZE = 20;
	private final int BALL_X = 300;
	private final int BALL_Y = 200;
	private int vx = 2;
	private int vy = 3;

// paddles
	private final int LEFT_PADDLE_X = 10;
	private final int LEFT_PADDLE_Y = 230;
	private final int RIGHT_PADDLE_X = 565;
	private final int RIGHT_PADDLE_Y = 230;
	private final int PADDLE_HEIGHT = 60;
	private final int PADDLE_WIDTH = 10;
	private final int PADDLE_VY = 20;

	public void run() {
// your code goes here...
		setup();

// GameLoop
		while (true) {
			moveBall();
			checkForCollision();
			pause(DELAY);
		}
	}

	private void setup() {
		setSize(WIDTH, HEIGHT);

		setBackground(Color.BLACK);

		addKeyListeners();

		createPongLabel();
		createEndScreen();
		createBall();
		createLeftPaddle();
		createRightPaddle();
	}

	private void createPongLabel() {
		pong = new GLabel("PONG");
		pong.setFont("SansSerif-150");
		pong.setColor(Color.DARK_GRAY);
		add(pong, PONG_X, PONG_Y);
	}

	private void createEndScreen() {
		winnerLeft = new GLabel("Player RED won ");
		winnerLeft.setFont("SansSerif-60");
		winnerLeft.setColor(Color.RED);

		winnerRight = new GLabel("Player BLUE won");
		winnerRight.setFont("SansSerif-60");
		winnerRight.setColor(Color.BLUE);
	}

	private void createBall() {
		ball = new GOval(BALL_SIZE, BALL_SIZE);
		ball.setColor(Color.WHITE);
		ball.setFilled(true);
		ball.setFillColor(Color.WHITE);
		add(ball, BALL_X, BALL_Y);
	}

	private void createLeftPaddle() {
		leftPaddle = new GRect(PADDLE_WIDTH, PADDLE_HEIGHT);
		leftPaddle.setColor(Color.RED);
		leftPaddle.setFilled(true);
		leftPaddle.setFillColor(Color.RED);
		add(leftPaddle, LEFT_PADDLE_X, LEFT_PADDLE_Y);
	}

	private void createRightPaddle() {
		rightPaddle = new GRect(PADDLE_WIDTH, PADDLE_HEIGHT);
		rightPaddle.setColor(Color.BLUE);
		rightPaddle.setFilled(true);
		rightPaddle.setFillColor(Color.BLUE);
		add(rightPaddle, RIGHT_PADDLE_X, RIGHT_PADDLE_Y);
	}

	private void moveBall() {
		ball.move(vx, vy);
	}

	private void checkForCollision() {
		checkForCollisionWithWindow();
		checkForCollisionWithPaddles();
		checkForCollisionWithEndScreen();
	}

	private void checkForCollisionWithWindow() {
		double y = ball.getY();
		if ((y < 0) || (y > HEIGHT - 60 - BALL_SIZE)) {
			vy = -vy;
		}
	}

	private void checkForCollisionWithPaddles() {
		double x = ball.getX();
		double y = ball.getY();
		GObject obj = getElementAt(x, y + BALL_SIZE / 2);
		GObject objTwo = getElementAt(x + BALL_SIZE, y + BALL_SIZE / 2);
		if (obj != null && obj != ball && obj != pong) {
			vx = -vx + 1;
		}
		if (objTwo != null && objTwo != ball && objTwo != pong) {
			vx = -vx - 1;
		}
	}

	private void checkForCollisionWithEndScreen() {
		double x = ball.getX();
		if (x < 0) {
			add(winnerRight, WINNER_RIGHT_X, WINNER_RIGHT_Y);
			remove(pong);
			vx = 0;
			vy = 0;
		}
		if (x > WIDTH) {
			add(winnerLeft, WINNER_LEFT_X, WINNER_LEFT_Y);
			remove(pong);
			vx = 0;
			vy = 0;
		}

	}

	public void keyPressed(KeyEvent e) {
		char c = e.getKeyChar();
		switch (c) {
		case 'p': // right paddle up
			rightPaddle.move(0, -PADDLE_VY);
			break;
		case 'l': // right paddle down
			rightPaddle.move(0, PADDLE_VY);
			break;
		case 'q': // left paddle up
			leftPaddle.move(0, -PADDLE_VY);
			break;
		case 'a': // left paddle down
			leftPaddle.move(0, PADDLE_VY);
			break;
		}
	}
}