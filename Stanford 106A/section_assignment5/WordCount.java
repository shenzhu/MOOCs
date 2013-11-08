/*
 * File: WordCount.java
 * ---------------------
 * This program counts the characters, words and lines in a file.
 */

import acm.program.*;
import java.io.*;

public class WordCount extends ConsoleProgram{
	public void run(){
		int lines = 0;
		int words = 0;
		int chars = 0;
		BufferedReader rd = openFileReader("File: ");
		try{
			while(true){
				
			}
		}
	}
	
	private BufferedReader openFileReader(String prompt){
		BufferedReader rd = null;
		while(rd == null){
			String name = readLine(prompt);
			try{
				rd = new BufferedReader(new FileReader(name));
			}catch(IOException ex){
				println("Can't open that file.");
			}
		}
		return rd;
	}
}
