/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	
	private static final int SENTINEL = 0;
	
	public void run() {
		
		// Collect User Input
		print("Enter an integer: ");
		int input = readInt();
		
		// If sentinel is hit first then give message
		if (input==SENTINEL) {
			print("First input was the sentinal. No Min/Max can be given.");
		}
		else {
			
			// Intialize Min & Max
			int min = input;
			int max = input;
			
			// Loop until Sentinel is Entered
			while(input!=SENTINEL){
				
				// Collect User Input
				print("Enter an integer: ");
				input = readInt();
				
				// Break if Sentinel is entered
				if (input == SENTINEL) break;
				
				// Determine if Max
				if (input>max) {
					max = input;
				}
				
				// Determine if Min
				if (input<min) {
					min = input;
				}
				
				
			}
			
			// Once broken out, give min/max
			println("Your min was " + min);
			println("Your max was " + max);
		}
		
		
	}
}

