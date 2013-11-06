/* File: Target.java */
/* This program draws a target shape */
import acm.graphics.*;
import acm.program.*;

import java.awt.*;

public class Target extends GraphicsProgram {
	public void run(){
		drawOuterCircle();
		drawMiddleCircle();
		drawInnerCircle();
	}
	
	private void drawOuterCircle(){
		int x = getWidth() / 2 - RADIUS;
		int y = getHeight() / 2 - RADIUS;
		GOval outer = new GOval(x, y, RADIUS * 2, RADIUS * 2);
		outer.setFilled(true);
		outer.setFillColor(Color.RED);
		add(outer);
	}
	
	private void drawMiddleCircle(){
		double r = RADIUS * 0.65;
		double x = getWidth() / 2 - r;
		double y = getHeight() / 2 - r;
		GOval middle = new GOval(x, y, r * 2, r * 2);
		middle.setFilled(true);
		middle.setFillColor(Color.WHITE);
		add(middle);
	}
	
	private void drawInnerCircle(){
		double r = RADIUS * 0.3;
		double x = getWidth() / 2 - r;
		double y = getHeight() / 2 - r;
		GOval inner = new GOval(x, y, r * 2, r * 2);
		inner.setFilled(true);
		inner.setFillColor(Color.RED);
		add(inner);
	}
	
	private static final int RADIUS = 72;
}
