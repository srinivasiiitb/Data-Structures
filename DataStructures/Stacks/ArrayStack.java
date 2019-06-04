/**
 * 
 */
package com.github.srinivasiiitb.datastructures.stacks;

import java.util.ArrayList;

/**
 * @author Srinivas Pakala
 *
 * This is the implementation for stack data structure using basic array.
 * This can be implemented in similar fashion using ArrayList
 * getMax() and getMin() are the custom methods added to get max and min values respectively
 * at any time in O(1) time.
 */
public class ArrayStack {

	private int CAPACITY = 4;
	private int top = -1;
	private int[] arr = new int[CAPACITY];
	private boolean CUSTOM_CAPACITY = false;
	
	private ArrayList<Integer> maxMinArray =  new ArrayList<>();
	public ArrayStack() {	
	}
	
	public ArrayStack(int capacity) {
		CUSTOM_CAPACITY = true;
		CAPACITY = capacity;
		arr= new int[CAPACITY];
	}
	
	public void push(int i) {
		
		if(top+1>=CAPACITY && CUSTOM_CAPACITY) {
			System.out.println("Stack is full. Can't insert new element");
			return;
		}else if(top+1>=CAPACITY) {
			CAPACITY = 2*CAPACITY;
			int[] newArray = new int[CAPACITY];
			for(int x=0;x<arr.length;x++) {
				newArray[x] = arr[x];
			}
			arr= newArray;
		}
		if(maxMinArray.size()==0)
			maxMinArray.add(i);
		else if(i>maxMinArray.get(maxMinArray.size()-1))
			maxMinArray.add(i);
		else if(i<maxMinArray.get(0))
			maxMinArray.add(0,i);
		arr[++top] =  i;
	}
	
	public void pop() {
		if(top==-1) {
			System.out.println("There are no elements to pop");
			return;
		}
		if(arr[top] == maxMinArray.get(maxMinArray.size()-1)) {
			//maxMinArray.remove(arr[top]);
			maxMinArray.remove(Integer.valueOf(arr[top]));
		}
		top--;
	}
	
	public int top() {
		return arr[top];
	}
	
	public int size() {
		return top+1;
	}
	
	public Boolean isEmpty() {
		return top==-1;
	}
	
	public int[] toArray() {
		int[] ar=  new int[top+1];
		for(int i=0;i<ar.length;i++)
			ar[i] =  arr[i];
		return ar;
	}
	
	public int getMax() {
		if(maxMinArray.size()==0) {
			System.out.println("There are no elements in the stack to get max");
			return -1;
		}
		return maxMinArray.get(maxMinArray.size()-1);		
	}
	
	public int getMin() {
		if(maxMinArray.size()==0) {
			System.out.println("There are no elements in the stack to get min");
			return -1;
		}
		return maxMinArray.get(0);		
	}
}
