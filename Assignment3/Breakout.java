/*
 * File: Breakout.java
 * -------------------
 * Name: Thomas Thompson
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;
	
// Game Delay for animation
	private static final int DELAY = 10;
	
	
// Globally Scope the Paddle and Ball
	private GRect paddle;
	private GOval ball;
	
// Global Scope for Ball Velocities
	private double vx, vy;
	
// Global Scope for current Turns
	private int currTurns = NTURNS;
	
	

/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		
		// Add Mouse Listeners
		addMouseListeners();
		
		// Initialize Game (build boxes)
		initGame();
		
		// Play Game
		play();
	}
	
	
/** Builds the Game Board & Paddle. */
	private void initGame(){
		
		// Draw Bricks
		buildBricks();
		
		// Draw Paddle
		drawPaddle();
		
		// Draw Ball
		createBall();
		
	}
	
	
	// Builds the Bricks (rainbow colored)
	private void buildBricks() {
		
		// Iterate over each row of bricks
		for (int i=0; i<NBRICK_ROWS; i++) {
			
			// Determine color of row
			Color rowColor;
			if (i==0 || i==1) {
				rowColor = Color.red;
			}
			else if (i==2 || i==3) {
				rowColor = Color.orange;
			}
			else if (i==4 || i==5) {
				rowColor = Color.yellow;
			}
			else if (i==6 || i==7) {
				rowColor = Color.green;
			}
			else if (i==8 || i==9) {
				rowColor = Color.cyan;
			}
			else {
				rowColor = Color.pink;
			}
			
			// Iterate within each row to draw bricks
			for (int j=0; j<NBRICKS_PER_ROW; j++) {
				
				// Determine Current Brick Position
				double x = BRICK_SEP/2 + j*(BRICK_WIDTH + BRICK_SEP);
				double y = BRICK_Y_OFFSET + i*(BRICK_HEIGHT + BRICK_SEP);
				
				// Create & Append Current Brick
				GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
				brick.setFilled(true);
				brick.setColor(rowColor);				
				add(brick);	
				
				
			}
			
		}
		
	}
	
	
	// Draws the paddle (black color)
	private void drawPaddle() {
		
		// Determine Paddle Position
		double x = WIDTH/2 - PADDLE_WIDTH/2;
		double y = HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT;
			
		// Create & Append Paddle
		paddle = new GRect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		paddle.setColor(Color.black);				
		add(paddle);
		
	}
	
	
	// Moves the paddle in response to the mouse movements
	public void mouseMoved(MouseEvent e) {
		
		// Determine limitations to move
		int leftX = 0;
		int rightX = WIDTH - PADDLE_WIDTH;
		
		// Get current X (and static y)
		double x = e.getX();
		double y = HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT;
		
		// Move Paddle if within game region
		if (leftX >= 0 && x <= rightX) {			
			paddle.setLocation(x, y);
		}
		
	}
	
	
	// Create the ball
	private void createBall() {
		
		// Determine start location of ball
		double x = WIDTH/2 - BALL_RADIUS/2;
		double y = HEIGHT/2 - BALL_RADIUS/2;
		
		// Create & Append Ball
		ball = new GOval(x, y, BALL_RADIUS, BALL_RADIUS);
		ball.setFilled(true);
		ball.setColor(Color.black);				
		add(ball);
		
		// Initialize Ball Velocities
		RandomGenerator rgen = RandomGenerator.getInstance();
		vx = rgen.nextDouble(1.0, 3.0);
		if (rgen.nextBoolean(0.5)) {
			vx = -vx;
		}
		vy = 3;
		
	}
	
	
	/** Plays the Game */
	private void play(){
		
		// Keeps running while turns available
		while(currTurns > 0) {
			
			// Moves Ball 
			animateBall();
			
			
		}
		
	}
	
	
	// Animate the Ball (move it)
	private void animateBall() {
		
		// Move Ball
		ball.move(vx, vy);
		
		// Check Collision
		checkCollision();
		
		// Delay few milliseconds
		pause(DELAY);
		
	}
	
	
	private void checkCollision() {
		
		// Get ball position
		GPoint ballPosition = ball.getLocation();
		double ballX = ballPosition.getX();
		double ballY = ballPosition.getY();

		// Ball touches left wall
		if (ballX <= 0) {
			vx = -vx;
		}
		
		// Ball touches right wall (account for the x,y of ball as top left of square)
		if(ballX >= WIDTH - BALL_RADIUS*2) {
			vx = -vx;
		}
		
		// Ball touches top wall
		if(ballY <= 0) {
			vy = -vy;
		}
		
		// Ball touches bottom wall (account for the x,y of ball as top left of square)
		if(ballY >= HEIGHT - BALL_RADIUS*2) {
			resetBall();
		}
		
	}
	
	
	// Reset Ball if hits bottom
	private void resetBall() {
		
		// Decrement Turns left
		currTurns = currTurns - 1;
		
		// Check for game loss
		if (currTurns == 0) {
			System.out.println("Game Over");
		}
		else {
			System.out.println(currTurns + " Turn(s) Left!");
			
			// Move ball back to starting position
			double x = WIDTH/2 - BALL_RADIUS/2;
			double y = HEIGHT/2 - BALL_RADIUS/2;
			ball.setLocation(x, y);
			
			// Reset Ball Velocities
			RandomGenerator rgen = RandomGenerator.getInstance();
			vx = rgen.nextDouble(1.0, 3.0);
			if (rgen.nextBoolean(0.5)) {
				vx = -vx;
			}
			vy = 3;
			
		}
		
	}

}
