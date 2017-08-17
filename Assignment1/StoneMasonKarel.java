/*
 * Problem 2
 * 
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	// Stone Mason Karel
	public void run() {		
		
		// Look Upward
		turnLeft();
		
		// Keep Placing things until front is not clear
		while(frontIsClear()) {
		
			keepPlacingBeepersUntilWall();
			positionForNextDownwardRun();
			keepPlacingBeepersUntilWall();
			positionForNextUpwardRun();
		
		}	
		
	}
	
	// Move and place beepers as needed until top wall is hit
	private void keepPlacingBeepersUntilWall() {
		
		// Keep placing beepers as needed
		while (frontIsClear()) {
			if (!beepersPresent()) {
				putBeeper();
			}
			move();
		}
		
		// Place last beeper if needed
		if (!beepersPresent()) {
			putBeeper();
		}
		
	}
	
	// Position Karel for a downward run
	private void positionForNextDownwardRun() {
		turnRight();
		
		// Only proceed if clear, otherwise we are done
		if(frontIsClear()){
			move();
			move();
			move();
			move();
			turnRight();
		}
	}
	
	// Position Karel for an upward run
	private void positionForNextUpwardRun(){
		turnLeft();
		
		// Only proceed if clear, otherwise we are done
		if(frontIsClear()){
			move();
			move();
			move();
			move();
			turnLeft();
		}
	}
	
}
