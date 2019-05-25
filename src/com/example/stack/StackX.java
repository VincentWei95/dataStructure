package com.example.stack;

public class StackX {
	
	private int maxSize;
	private char[] stackArray;
	private int top;
	
	public StackX(int maxSize) {
		this.maxSize = maxSize;
		stackArray = new char[maxSize];
		top = -1;
	}
	
	public void push(char item) {
		stackArray[++top] = item;
	}
	
	public char pop() {
		return stackArray[top--];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == maxSize - 1;
	}

}
