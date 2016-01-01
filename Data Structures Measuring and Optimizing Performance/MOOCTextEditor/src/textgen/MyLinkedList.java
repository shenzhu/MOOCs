package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// Implemented this method
		this.head = new LLNode<E>(null);
		this.tail = new LLNode<E>(null);
		
		this.head.next = this.tail;
		this.tail.prev = this.head;
		// set size
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// Implemented this method
		// create node
		LLNode<E> newNode = new LLNode<E>(element);
		
		if(element == null){
			throw new NullPointerException("Null Pointer Exception");
		}
		
		if(this.size == 0){
			this.head.next = newNode;
			this.tail.prev = newNode;
			
			newNode.prev = this.head;
			newNode.next = this.tail;
		}else{
			this.tail.prev.next = newNode;
			newNode.prev = this.tail.prev;
			newNode.next = this.tail;
			this.tail.prev = newNode;
		}
		
		this.size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// Implemented this method
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException("index " + index + " is out of bound");
		}
		
		LLNode<E> currentNode = this.head.next;
		for(int i = 0; i < index; i++){
			currentNode = currentNode.next;
		}
			
		return currentNode.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// Implemented this method
		if(index < 0 || index > this.size()){
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		
		if(element == null){
			throw new NullPointerException("null pointer exception");
		}
		
		LLNode<E> newNode = new LLNode<E>(element);
		/**
		if(index == 0){
			this.head.next.prev = newNode;
			newNode.next = this.head.next;
			newNode.prev = this.head;
			this.head.next = newNode;
		}
		
		if(index == this.size() - 1){
			this.tail.prev.next = newNode;
			newNode.prev = this.tail.prev;
			newNode.next = this.tail;
			this.tail.prev = newNode;
		}
		*/
		
		LLNode<E> currentNode = this.head.next;
		for(int i = 0; i < index; i++){
			currentNode = currentNode.next;
		}
		currentNode.prev.next = newNode;
		newNode.prev = currentNode.prev;
		newNode.next = currentNode;
		currentNode.prev = newNode;
		
		this.size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// Implemented this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// Implemented this method
		if(index < 0 || index >= this.size()){
			throw new IndexOutOfBoundsException("Index out of bound");
		}
		
		LLNode<E> currentNode = this.head.next;
		for(int i = 0; i < index; i++){
			currentNode = currentNode.next;
		}
		currentNode.next.prev = currentNode.prev;
		currentNode.prev.next = currentNode.next;
		currentNode.prev = null;
		currentNode.next = null;
		
		this.size--;
		return currentNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// Implemented this method
		if(index < 0 || index >= this.size()){
			throw new IndexOutOfBoundsException("Index out of bound");
		}
		
		if(element == null){
			throw new NullPointerException("Null Pointer Exception");
		}
		
		LLNode<E> currentNode = this.head.next;
		for(int i = 0; i < index; i++){
			currentNode = currentNode.next;
		}
		E replacedElement = currentNode.data;
		currentNode.data = element;
		
		return replacedElement;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// Added any other methods you think are useful here
	// E.g. you might want to add another constructor
	// another constructor and toString   

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e, LLNode<E> prevNode, LLNode<E> nextNode){
		this.data = e;
		this.prev = prevNode;
		this.next = nextNode;
	}
	
	public String toString(){
		String nodeData = (String)this.data;
		//System.out.println(nodeData);

		return nodeData;
	}

}
