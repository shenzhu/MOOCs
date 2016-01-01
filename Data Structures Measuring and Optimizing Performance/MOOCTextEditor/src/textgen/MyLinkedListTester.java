/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// Added more tests here
		try {
			int b = emptyList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			int c = emptyList.remove(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // implemented this test
		shortList.add("testadd");
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Chekc second", "B", shortList.get(1));
		assertEquals("Check third", "testadd", shortList.get(2));
		assertEquals("Check size", 3, shortList.size());
		
		emptyList.add(1);
		assertEquals("Check first", (Integer)1, emptyList.get(0));
		try{
			emptyList.get(1);
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e){
			
		}
		
		try{
			emptyList.add(null);
			fail("Check out of bounds");
		}
		catch(NullPointerException e){
			
		}
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// implemented this test
		assertEquals("emptyList size", 0, emptyList.size());
		
		// size() after add one element
		emptyList.add(1);
		emptyList.add(2);
		assertEquals("check add", 2, emptyList.size());
		emptyList.add(0, 0);
		assertEquals("chekc add", 3, emptyList.size());
		
		// size() after remove
		emptyList.remove(0);
		assertEquals("check remove", 2, emptyList.size());
		
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // implemented this test
		try{
			emptyList.add(-1, 1);
			fail("Check negative index");
		}
		catch (IndexOutOfBoundsException e){
			
		}
		
		try{
			shortList.add(3, "C");
			fail("Check index out of bounds");
		}
		catch(IndexOutOfBoundsException e){
			
		}
		
		try{
			shortList.add(null);
			fail("Check null pointer exception");
		}
		catch(NullPointerException e){
			
		}
		
		shortList.add(0, "testadd");
		assertEquals("Check first", "testadd", shortList.get(0));
		assertEquals("Check second", "A", shortList.get(1));
		assertEquals("Check third", "B", shortList.get(2));
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // implemented this test
		try{
			int a = list1.set(-1, 10);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e){
			
		}
		
		try{
			int a = list1.set(5, 10);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e){
			
		}
		
		try{
			int a = list1.set(0, null);
			fail("Check null pointer exception");
		}
		catch (NullPointerException e){
			
		}
		
		assertEquals("Check first", (Integer)65, list1.get(0));
		assertEquals("Check second", (Integer)21, list1.get(1));
		assertEquals("Check third", (Integer)42, list1.get(2));
		
		int index0 = list1.set(0, 10);
		int index1 = list1.set(1, 20);
		assertEquals("Check first", (Integer)10, list1.get(0));
		assertEquals("Check second", (Integer)20, list1.get(1));
	}
	
	
	// TODO: Optionally add more test methods.
	
}
