package com.example.stack;

/*
 * ջ���Ƚ������ֻ����ջ�����в����ɾ������
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
