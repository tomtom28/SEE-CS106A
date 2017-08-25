/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	
	private static final int PIXELS_PER_INCH = 72;
	
	private static final double BIG_RADIUS = 1*PIXELS_PER_INCH;
	private static final double MEDIUM_RADIUS = 0.65*PIXELS_PER_INCH;
	private static final double SMALL_RADIUS = 0.3*PIXELS_PER_INCH;
	
	
	public void run() {
		
		// Draw Big Circle
		GOval bigO = makeCircle(BIG_RADIUS, Color.red);
		add(bigO);
		
		// Draw Medium Circle
		GOval medO = makeCircle(MEDIUM_RADIUS, Color.white);
		add(medO);
		
		// Draw Small Circle
		GOval smallO = makeCircle(SMALL_RADIUS, Color.red);
		add(smallO);
		
	}
	
	private GOval makeCircle(double radius, Color color) {
		
		// Get Center Point
		double x = getWidth()/2 - radius/2;
		double y = getHeight()/2 - radius/2;
		
		// Create Circle with given radius and color
		GOval circle = new GOval(x, y, radius, radius);
		circle.setFilled(true);
		circle.setColor(color);
		
		return circle;
	}
	
	
}
