/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	
	private static final int BOX_HEIGHT = 50;
	private static final int BOX_WIDTH = 175;
	

	public void run() {
		
		// Get Window Size
		int windowWidth = getWidth();
		int windowHeight = getHeight();
		
		// Draw "Program" Box & Add Label
		double x0 = windowWidth/2 - BOX_WIDTH/2; // center of window
		double y0 = (windowHeight/2 + BOX_HEIGHT/2) - (2.5*BOX_HEIGHT); // moved 2.5 box heights up from center
		GRect programBox = new GRect(x0, y0, BOX_WIDTH, BOX_HEIGHT);
		add(programBox);
		GLabel programBoxLabel = new GLabel("Program", (x0 + BOX_WIDTH/2), (y0 + BOX_HEIGHT/2));
		double programBoxLabelx = programBoxLabel.getWidth()/2;
		double programBoxLabely = programBoxLabel.getHeight()/2;
		programBoxLabel.move(-programBoxLabelx, programBoxLabely);
		add(programBoxLabel);
		
		// Draw "ConsoleProgram" Box & Add Label
		double y1 = (windowHeight/2 + BOX_HEIGHT/2) + BOX_HEIGHT; // moved 1 box height down from center
		GRect ConsoleProgramBox = new GRect(x0, y1, BOX_WIDTH, BOX_HEIGHT);
		add(ConsoleProgramBox);
		GLabel ConsoleProgramLabel = new GLabel("ConsoleProgram", (x0 + BOX_WIDTH/2), (y1 + BOX_HEIGHT/2));
		double ConsoleProgramLabelx = ConsoleProgramLabel.getWidth()/2;
		double ConsoleProgramLabely = ConsoleProgramLabel.getHeight()/2;
		ConsoleProgramLabel.move(-ConsoleProgramLabelx, ConsoleProgramLabely);
		add(ConsoleProgramLabel);
		
		// Draw "GraphicsProgram" Box & Add Label
		double x1 = windowWidth/2 - BOX_WIDTH/2 - 1.5*BOX_WIDTH; // moved 1.5 box width left of center of window
		GRect GraphicsProgramBox = new GRect(x1, y1, BOX_WIDTH, BOX_HEIGHT);
		add(GraphicsProgramBox);
		GLabel GraphicsProgramLabel = new GLabel("GraphicsProgram", (x1 + BOX_WIDTH/2), (y1 + BOX_HEIGHT/2));
		double GraphicsProgramLabelx = GraphicsProgramLabel.getWidth()/2;
		double GraphicsProgramLabely = GraphicsProgramLabel.getHeight()/2;
		GraphicsProgramLabel.move(-GraphicsProgramLabelx, GraphicsProgramLabely);
		add(GraphicsProgramLabel);
		
		// Draw "DialogProgram" Box & Add Label
		double x2 = windowWidth/2 - BOX_WIDTH/2 + 1.5*BOX_WIDTH; // moved 1.5 box width right of center of window
		GRect DialogProgramBox = new GRect(x2, y1, BOX_WIDTH, BOX_HEIGHT);
		add(DialogProgramBox);
		GLabel DialogProgramLabel = new GLabel("DialogProgram", (x2 + BOX_WIDTH/2), (y1 + BOX_HEIGHT/2));
		double DialogProgramLabelx = DialogProgramLabel.getWidth()/2;
		double DialogProgramLabely = DialogProgramLabel.getHeight()/2;
		DialogProgramLabel.move(-DialogProgramLabelx, DialogProgramLabely);
		add(DialogProgramLabel);
		
		// Draw Line to ConsoleProgram Box
		double xx0 = x0 + BOX_WIDTH/2;
		double yy0 = y0 + BOX_HEIGHT;
		double xx1 = x1 + BOX_WIDTH/2;
		double yy1 = y1;
		GLine ConsoleProgramLine = new GLine(xx0,yy0,xx1,yy1);
		add(ConsoleProgramLine);
		
		// Draw Line to GraphicsProgram Box
		GLine GraphicsProgramLine = new GLine(xx0,yy0,xx0,yy1);
		add(GraphicsProgramLine);
		
		// Draw line to DialogProgram Box
		double xx2 = xx0 + 1.5*BOX_WIDTH;
		GLine DialogProgramLine = new GLine(xx0,yy0,xx2,yy1);
		add(DialogProgramLine);
		
	}
}

