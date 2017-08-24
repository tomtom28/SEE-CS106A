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
		
		// Determine Even v. Odd Height
		boolean boardHeightIsEven;
		if (placeEveryOtherBeeper() % 2 == 0) {
			boardHeightIsEven = true;
			positionDownwardEven();
		}
		else {
			boardHeightIsEven = false;
			positionDownwardOdd();
		}
		
		
		// Tile rest of board depending on even or odd
		if (boardHeightIsEven) {
			
			while( frontIsClear() ) {
				placeEveryOtherBeeper();
				positionUpwardEven();
				placeEveryOtherBeeper();
				positionDownwardEven();
			}
			
		}
		else {
			
			while( frontIsClear() ) {
				placeEveryOtherBeeper();
				positionUpwardOdd();
				placeEveryOtherBeeper();
				positionDownwardOdd();
			}
		}	
		
	}
	
	// Add every other beeper
	private int placeEveryOtherBeeper(){
		int step = 0;
		while (frontIsClear()) {
			move();
			putBeeper();
			if (frontIsClear()) {
				move();
				step++;
			}
			step++;
		}
		return step;
	}
	
	
	// Position for Downward Run by dropping first beeper
	private void positionDownwardEven(){
		turnRight();
		if (frontIsClear()) {
			move();
			
			turnRight();
			putBeeper();
			if (frontIsClear()) {
				move();
			}
		}

	}
	
	// Position for Downward Run by dropping first beeper
	private void positionDownwardOdd(){
		turnRight();
		if (frontIsClear()) {
			move();
			
			turnRight();
		}
	}
	
	
	// Position for Downward Run by dropping first beeper
	private void positionUpwardEven(){
		turnLeft();
		if (frontIsClear()) {
			move();
			
			turnLeft();
			putBeeper();
			if (frontIsClear()) {
				move();
			}
		}

	}
	
	// Position for Upward Run by dropping second beeper
	private void positionUpwardOdd(){
		turnLeft();
		if (frontIsClear()) {
			move();
			
			turnLeft();
			putBeeper();
			if (frontIsClear()) {
				move();
			}
		}
	}

}
