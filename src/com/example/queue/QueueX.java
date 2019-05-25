package com.example.queue;

/*
 * û�м�����itemSize�Ķ��У��ڽ��д������ݲ���ʱ��itemSize����һ���̶���Ӱ�����ܣ�������rear��front�����㣬���Ƚϸ���
 */
public class QueueX {
	
	private int rear; // ָ���β
	private int front; // ָ���ͷ
	private int[] queueArray;
	private int maxSize;
	
	public QueueX(int size) {
		maxSize = size + 1;
		queueArray = new int[maxSize];
		rear = -1;
		front = 0;
	}
	
	public void insert(int item) {
		if (rear == maxSize - 1) // �������������ٲ�������ʱ��rear���Ƶ�-1λ��
			rear = -1;
		queueArray[++rear] = item;
	}

	public int remove() {
		int item = queueArray[front++];
		if (front == maxSize) // ������Ϊ�գ����Ƴ�����ʱ��front���Ƶ�0λ��
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
