/* File: RandomCircle.java */
/* This program draws circles randomly */
import acm.program.*;
import acm.graphics.*;
import acm.util.*;

public class RandomCircle extends GraphicsProgram{
	public void run(){
		for(int i = 0; i < numberOfCircles; i++){
			drawCircle();
		}
	}
	
	private void drawCircle(){
		double radius = rgen.nextDouble(minRadius, maxRadius);
		double x = rgen.nextDouble(0, getWidth() - radius * 2);
		double y = rgen.nextDouble(0, getHeight() - radius * 2);
		GOval circle = new GOval(x, y, radius * 2, radius * 2);
		circle.setFilled(true);
		circle.setFillColor(rgen.nextColor());
		add(circle);
	}
	
	/* fixed parameters and random generator */
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private static final int numberOfCircles = 10;
	private static final int minRadius = 5;
	private static final int maxRadius = 50;
}
