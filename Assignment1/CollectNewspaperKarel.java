/*
 * Problem 1 
 * 
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {

	// Collect newspaper and go back to start
	public void run() {
		moveToNewspaper();
		pickUpNewspaper();
		returnToStart();
	}
	
	// Move to the newspaper
	private void moveToNewspaper() {
		move();
		move();
		turnRight();
		move();
		turnLeft();
		move();
	}
	
	// Pick newspaper up
	private void pickUpNewspaper() {
		pickBeeper();
	}
	
	
	// Return to starting point
	private void returnToStart() {
		turnAround();
		move();
		move();
		move();
		turnRight();
		move();
		turnRight();
	}

}
