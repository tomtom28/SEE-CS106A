/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	// Checkers Karel
	public void run() {
		
		// Look Up & Place First Beeper
		turnLeft();
		putBeeper();
		
		// Move Up if possible
		if (frontIsClear()) {
			move();
		}
		
		
		placeEveryOtherBeeper();
		
		
		positionDownwardEven();
		placeEveryOtherBeeper();
		
		positionUpwardEven();
		placeEveryOtherBeeper();
		
		
		
		positionDownwardEven();
		placeEveryOtherBeeper();
		
		positionUpwardEven();
		placeEveryOtherBeeper();
		
		
		
		positionDownwardEven();
		placeEveryOtherBeeper();
		
		positionUpwardEven();
		placeEveryOtherBeeper();
		
		
		
		positionDownwardEven();
		placeEveryOtherBeeper();
		
		positionUpwardEven();
		
		
		
	}
	
	// Add every other beeper
	private void placeEveryOtherBeeper(){
		while (frontIsClear()) {
			move();
			putBeeper();
			if (frontIsClear()) {
				move();
			}
		}
	}
	
	
	// Position for Downward Run by dropping first beeper
	private void positionDownwardEven(){
		turnRight();
		if (frontIsClear()) {
			move();
		}
		turnRight();
		putBeeper();
		if (frontIsClear()) {
			move();
		}
	}
	
	
	
	
	// Position for Downward Run by dropping first beeper
	private void positionUpwardEven(){
		turnLeft();
		if (frontIsClear()) {
			move();
		}
		turnLeft();
		putBeeper();
		if (frontIsClear()) {
			move();
		}
	}
	
	// Position for Upward Run by dropping second beeper
	private void positionUpwardSecondDrop(){
		turnLeft();
		if (frontIsClear()) {
			move();
		}
		turnLeft();
	}

}
