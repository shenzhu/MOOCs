package spelling;

import static org.junit.Assert.assertEquals;

import java.util.List;

public class WriteTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AutoCompleteDictionaryTrie emptyDict; 
		AutoCompleteDictionaryTrie smallDict;
		
		emptyDict = new AutoCompleteDictionaryTrie();
		smallDict = new AutoCompleteDictionaryTrie();

		smallDict.addWord("Hello");
		smallDict.addWord("HElLo");
		smallDict.addWord("help");
		smallDict.addWord("he");
		smallDict.addWord("hem");
		smallDict.addWord("hot");
		smallDict.addWord("hey");
		smallDict.addWord("a");
		smallDict.addWord("subsequent");
		
		//smallDict.printTree();
		
		List<String> completions;
		completions = smallDict.predictCompletions("he",  2);
		
		for(String completion : completions){
			System.out.print(completion + " ");
		}
	}

}
