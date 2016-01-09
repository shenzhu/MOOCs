package spelling;

import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/** 
 * An trie data structure that implements the Dictionary and the AutoComplete ADT
 * @author You
 *
 */
public class AutoCompleteDictionaryTrie implements  Dictionary, AutoComplete {

    private TrieNode root;
    private int size;
    

    public AutoCompleteDictionaryTrie()
	{
		root = new TrieNode();
	}
	
	
	/** Insert a word into the trie.
	 * For the basic part of the assignment (part 2), you should ignore the word's case.
	 * That is, you should convert the string to all lower case as you insert it. */
	public boolean addWord(String word)
	{
	    //TODO: Implement this method.
		char[] chArray = word.toCharArray();
		TrieNode currentNode = this.root;
		boolean insert = false;
		
		for(char c: chArray){
			if(currentNode.getChild(Character.toLowerCase(c)) != null){
				currentNode = currentNode.getChild(Character.toLowerCase(c));
				//check if the word already exists and if trie regards it as a word
				if(currentNode.getText().equals(word.toLowerCase()) && !currentNode.endsWord()){
					currentNode.setEndsWord(true);
					insert = true;
				}
			}
			//current char does not exist in trie, add new node
			else{
				currentNode = currentNode.insert(Character.toLowerCase(c));
				insert = true;
			}
		}
		currentNode.setEndsWord(true);
				
		//recalculate size
		if(insert){
			size++;
			return true;
		}else{
			return false;
		}
	}

	/** 
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size()
	{
	    //TODO: Implement this method
	    return this.size;
	}
	
	
	/** Returns whether the string is a word in the trie */
	@Override
	public boolean isWord(String s) 
	{
	    // TODO: Implement this method
		char[] chArray = s.toCharArray();
		TrieNode currentNode = this.root;
		
		//handle empty input
		if(chArray.length == 0){
			return false;
		}
		
		//search s
		for(char c: chArray){
			if(currentNode.getChild(Character.toLowerCase(c)) != null){
				currentNode = currentNode.getChild(Character.toLowerCase(c));
			}
			else{
				return false;
			}
		}
		if(currentNode.getText().equals(s.toLowerCase()) && currentNode.endsWord()){
			return true;
		}
		else{
			return false;
		}
	}

	/** 
	 *  * Returns up to the n "best" predictions, including the word itself,
     * in terms of length
     * If this string is not in the trie, it returns null.
     * @param text The text to use at the word stem
     * @param n The maximum number of predictions desired.
     * @return A list containing the up to n best predictions
     */@Override
     public List<String> predictCompletions(String prefix, int numCompletions) 
     {
    	 // TODO: Implement this method
    	 // This method should implement the following algorithm:
    	 // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
    	 //    empty list
    	 // 2. Once the stem is found, perform a breadth first search to generate completions
    	 //    using the following algorithm:
    	 //    Create a queue (LinkedList) and add the node that completes the stem to the back
    	 //       of the list.
    	 //    Create a list of completions to return (initially empty)
    	 //    While the queue is not empty and you don't have enough completions:
    	 //       remove the first Node from the queue
    	 //       If it is a word, add it to the completions list
    	 //       Add all of its child nodes to the back of the queue
    	 // Return the list of completions   	 
    	 char[] chArray = prefix.toCharArray();
    	 TrieNode currentNode = this.root;
    	 LinkedList<TrieNode> bfsq = new LinkedList<TrieNode>();
    	 List<String> suggestions = new LinkedList<String>();
    	 
    	 //find prefix in trie
    	 for(char c : chArray){
    		 if(currentNode.getChild(Character.toLowerCase(c)) != null){
    			 currentNode = currentNode.getChild(Character.toLowerCase(c));
    		 }
    	 }
    	 //if trie does not contains prefix, can't provide suggestions, return empty list
    	 if(!currentNode.getText().equals(prefix)){
    		 return suggestions;
    	 }
    	 
    	 //perform bfsearch from currentNode
    	 bfsq.add(currentNode);
		 //System.out.println(bfsq.size());
		 //System.out.println(suggestions.size());
    	 while(!bfsq.isEmpty() && suggestions.size() < numCompletions){
    		 TrieNode firstNode = bfsq.removeFirst();
    		 if(firstNode.endsWord() && !suggestions.contains(firstNode.getText())){
    			 suggestions.add(firstNode.getText());
    		 }
    		 Set<Character> childrenChars = firstNode.getValidNextCharacters();
    		 for(char c : childrenChars){
    			 bfsq.add(firstNode.getChild(c));
    		 }
    		 
    		 /*
    		 System.out.println(suggestions.size());
    		 for(String suggestion : suggestions){
    			 System.out.print(suggestion + " ");
    		 }
    		 */
    	 }
         return suggestions;
     }

 	// For debugging
 	public void printTree()
 	{
 		printNode(root);
 	}
 	
 	/** Do a pre-order traversal from this node down */
 	public void printNode(TrieNode curr)
 	{
 		if (curr == null) 
 			return;
 		
 		System.out.println(curr.getText());
 		
 		TrieNode next = null;
 		for (Character c : curr.getValidNextCharacters()) {
 			next = curr.getChild(c);
 			printNode(next);
 		}
 	}
 	

	
}