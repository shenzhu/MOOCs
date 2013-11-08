/*
 * File: UniqueName.java
 * ----------------------
 * This program list the unique names the user enters
 */

import acm.program.*;
import java.util.*;

public class UniqueNames extends ConsoleProgram{
	private ArrayList <String> names = new ArrayList <String> ();
	
	public void run(){
		askForNames();
		writeUniqueNames();
	}
	
	private void askForNames(){
		while(true){
			String name = readLine("Please enter a name: ");
			if(name.equals("")) break;
			
			if(!names.contains(name)){
				names.add(name);
			}
		}
		return;
	}
	
	private void writeUniqueNames(){
		println("Unique names: ");
		for(int i = 0; i < names.size(); i++){
			println(names.get(i));
		}
	}
}
