
/**
 * 
 */
package com.github.srinivasiiitb.datastructures.linkedlists;

/**
 * @author Srinivas Pakala
 * This is generic implemention of the linked list class with some basic methods.
 */
public class LinkedList<E> {

	private transient int size=0;
	private transient Node<E> first = null;
	private Node<E> last = null;
	
	private static class Node<E> {
		E item;
		Node<E> next;
		
		Node(E element){
			this.item= element;
			this.next=null;
		}
	}
	
	// add an element at the end of the list
	public void add(E e) {

		Node<E> node= new Node<>(e);
		if(first ==null)
			first = node;
		
		if(last == null)
			last = node;
		else {
			last.next=node;
			last=node;
		}
		size++;
	}
	
	public void addFirst(E e) {
	
		Node<E> node = new Node<>(e);
		if(first == null) first = node;
		else {
			node.next = first;
			first= node;
		}
		size++;
	}
	
	//remove the object at it first occurrence from the list
	public boolean remove(Object o) {
		
		if(first !=null && o.equals(first.item)) {
			first = first.next;
			size--;
			return true;
		}
		for(Node<E> node = first; node!=null; node=node.next ) {
			Node<E> x = node.next;
			if(x!=null && o.equals(x.item)) {
				node.next = x.next;
				size--;
				return true;
			}
		}
		return false;
	}
	
	//removes first element of the list
	public void remove() {
		if(first ==null) throw new IndexOutOfBoundsException();
		first = first.next;
		size--;
	}

	//returns size of the list
	public int size() {
		return size;
	}
	
	// returns element at specified index
	public E get(int index) {
		
		if(index > size) throw new IndexOutOfBoundsException();
		Node<E> x= first;
		if(index == 0) return first.item;
		for(int i=0;i<index;i++)
				x=x.next;
		
		return x.item;
	}
}
