/* File: Fibonacci.java */
/* This program prints the fibonacci sequence. */

import acm.program.*;

public class Fibonacci extends ConsoleProgram{
	
	public void run(){
		println("This program lists the Fibonacci sequence.");
		int a = 0;
		int b = 1;
		while(a <= MAX_TERM_VALUE){
			println(a);
			int c = a + b;
			a = b;
			b = c;	
		}
	}
	
	/* Defines the largest term to be displayer */
	private static final int MAX_TERM_VALUE = 10000;

}
