package com.example.queue;

/*
 * 没有计数项itemSize的队列，在进行大量数据操作时，itemSize会在一定程度上影响性能，可以用rear和front来计算，但比较复杂
 */
public class QueueX {
	
	private int rear; // 指向队尾
	private int front; // 指向队头
	private int[] queueArray;
	private int maxSize;
	
	public QueueX(int size) {
		maxSize = size + 1;
		queueArray = new int[maxSize];
		rear = -1;
		front = 0;
	}
	
	public void insert(int item) {
		if (rear == maxSize - 1) // 当队列已满，再插入数据时，rear回绕到-1位置
			rear = -1;
		queueArray[++rear] = item;
	}

	public int remove() {
		int item = queueArray[front++];
		if (front == maxSize) // 当队列为空，再移除数据时，front回绕到0位置
			front = 0;
		return item;
	}
	
	public boolean isEmpty() {
		return ((rear+1 == front) || (front+maxSize-1 == rear));
	}
	
	public boolean isFull() {
		return ((rear+2 == front) || (front+maxSize-2 == rear));
	}
	
	public int size() {
		if (rear >= front) {
			return rear-front+1;
		} else {
			return (maxSize-front) + (rear+1);
		}
	}
}
