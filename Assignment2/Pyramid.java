/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		
		// Get Total Pyramid Width
		int totalPyramidWidth = BRICKS_IN_BASE * BRICK_WIDTH;
		
		// Get Window Size
		int windowWidth = getWidth();
		int windowHeight = getHeight();
		
		// Iterate from bottom to top of pyramid
		for (int i=0; i<BRICKS_IN_BASE; i++) {
		
			// Iterate over current row
			for (int j=0; j<BRICKS_IN_BASE-i; j++) {
				
				// Find Current Positions
				int x = windowWidth/2 - (totalPyramidWidth - BRICK_WIDTH*i)/2 + BRICK_WIDTH*j;
				int y = windowHeight - BRICK_HEIGHT*(i+1) - 1; // minus 1 is to see the bottom pixel
				
				// Create & Append Current Rectangle
				GRect square = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
				add(square);	
				
			}	
			
		}
		
	}
}

