/* File: Pyramid.java */
/* This program draws the pyramid */
import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {
	
	/* defines the parameters for drawing pyramid */
	private static final int BRICK_WIDTH = 30;
	private static final int BRICK_HEIGHT = 12;
	private static final int BRICKS_IN_BASE = 14;
	
	public void run(){
		drawBricks();
	}
	
	/* draws all the bricks */
	public void drawBricks(){
		for(int row = 0; row < BRICKS_IN_BASE; row++){
			int brickNum = BRICKS_IN_BASE - row;
			for(int i = 0; i < brickNum; i++){
				int x = 150 + getWidth() / 2 - BRICK_WIDTH * brickNum / 2 + i * BRICK_WIDTH;
				int y = getHeight() - (row + 1) * BRICK_HEIGHT;
				
				GRect rect = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
				add(rect);
			}
		}
	}


}
