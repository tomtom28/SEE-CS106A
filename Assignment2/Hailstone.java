/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	
	public void run() {
		
		// Step Counter
		int counter = 0;
		
		// Collect user input
		print("Gimme a (positive) number: ");
		int n = readInt();
		
		while (n > 1) {
			// Even
			if (n%2 == 0) {
				n = isEven(n);
				counter++;
			}
			// Odd
			else {
				n = isOdd(n);
				counter++;
			}
		}
		
		// After loop, show final message
		println("The process took " + counter + " steps to complete.");
		
	}
	
	// If n is even, divide it by two. 
	private int isEven(int n) {
		println(n + " is even, so I take half and give back ... " + n/2);
		return n/2;
	}
	
	// If n is odd, multiply it by three and add one
	private int isOdd(int n) {
		println( n + " is odd, so I make 3n+1 and give back ... " + (3*n+1) );
		return n*3 + 1;
	}
	
	
}

