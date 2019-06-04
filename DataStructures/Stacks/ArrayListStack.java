package com.github.srinivasiiitb.datastructures.stacks;

import java.util.ArrayList;

/**
 * @author Srinivas Pakala
 *
 * This is the implementation for stack data structure using basic Array List.
 * getMax() and getMin() are the custom methods added to get max and min values respectively
 * at any time in O(1) time.
 *
 */

public class ArrayListStack {
	
	private int top = -1;
	private ArrayList<Integer> arr =  new ArrayList<>();	
	private ArrayList<Integer> maxMinArray =  new ArrayList<>();
	
	public void push(int i) {
		
		if(maxMinArray.size()==0)
			maxMinArray.add(i);
		else if(i>maxMinArray.get(maxMinArray.size()-1))
			maxMinArray.add(i);
		else if(i<maxMinArray.get(0))
			maxMinArray.add(0,i);
		arr.add(i);
		top++;
	}
	
	public void pop() {
		if(top==-1) {
			System.out.println("There are no elements to pop");
			return;
		}
		if(arr.get(top) == maxMinArray.get(maxMinArray.size()-1)) {
			maxMinArray.remove(Integer.valueOf(arr.get(top)));
		}
		arr.remove(top);
		top--;
	}
	
	public int top() {
		if(arr.size()==0) {
			System.out.println("There are no elements in the stack");
			return -1;
		}
		return arr.get(top);
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
			ar[i] =  arr.get(i);
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
