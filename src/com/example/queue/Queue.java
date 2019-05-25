package com.example.queue;

/*
 * �м�����itemSize�Ķ���
 * �Ƚ��ȳ����Ӷ�ͷɾ�����Ӷ�β����
 * 
 * ʱ�临�Ӷȣ�O(1)
 */
public class Queue {
	
	private int maxSize;
	private int rear;
	private int front;
	private int[] queueArray;
	private int itemSize;
	
	public Queue(int maxSize) {
		this.maxSize = maxSize;
		queueArray = new int[maxSize];
		rear = -1;
		front = 0;
		itemSize = 0;
	}
	
	public void insert(int item) {
		if (rear == maxSize - 1) 
			rear = -1;
		queueArray[++rear] = item;
		itemSize++;
	}
	
	public int remove() {
		int temp = queueArray[front++];
		if (front == maxSize)
			front = 0;
		itemSize--;
		return temp;
	}
	
	public boolean isEmpty() {
		return itemSize == 0;
	}
	
	public boolean isFull() {
		return itemSize == maxSize;
	}

}
