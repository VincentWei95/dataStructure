package com.example.stack;

/*
 * 栈，先进后出，只能在栈顶进行插入和删除操作
 */
public class Stack {
	
	private int maxSize;
	private int[] stackArray;
	private int top;
	
	public Stack(int maxSize) {
		this.maxSize = maxSize;
		stackArray = new int[maxSize];
		top = -1;
	}
	
	public void push(int item) {
		stackArray[++top] = item;
	}

	public int pop() {
		return stackArray[top--];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == maxSize - 1;
	}
}
