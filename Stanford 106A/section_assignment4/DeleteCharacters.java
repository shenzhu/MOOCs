/*
 * File: DeleteCharacters.java
 * ---------------------------
 * This program removes all occurrences of a specified character
 * from a string
 */

import acm.program.*;

public class DeleteCharacters extends ConsoleProgram{
	public void run(){
		while(true){
			String str = readLine("Enter a sentence: ");
			String getChar = readLine("Enter a letter you want to remove: ");
			char ch = getChar.charAt(0);
			int indexOfString = str.indexOf(ch);
			println(removeOccurrences(str, ch));
			if(indexOfString == -1){
				String input = readLine("The sentence dose not contain the letter, do you want to enter again(Y/N)?");
				char choose = input.charAt(0);
				if(choose == 'N'){
					break;
				}
			}
		}
	}
	
	private String removeOccurrences(String str, char ch){
		String result = "";
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) != ch){
				result = result + str.charAt(i);
			}
		}
		return result;
	}
}
