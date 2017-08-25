/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
		
		// Get User Input
		print("a: ");
		int a = readInt();
		print("b: ");
		int b = readInt();
		
		// Calculate sqrt and show result
		double c = Math.sqrt(a*a + b*b);
		print("c = " + c);
	}
}
