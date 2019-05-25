package com.example.queue;

/*
 * ���ȼ����У����簴��ֵ��С��Ϊ������ȼ�������ڶ�ͷ�����ȼ���ͷ��ڶ�β
 */
public class PriorityQueue {
	
	private int maxSize;
	private int[] queueArray;
	private int itemSize;
	
	public PriorityQueue(int maxSize) {
		this.maxSize = maxSize;
		queueArray = new int[maxSize];
		itemSize = 0;
	}
	
	public void insert(int item) {
		int j;
		
		if (itemSize == 0) { // ����û�����ݣ�ֱ�����
			queueArray[itemSize++] = item;
		} else {
			for (j = itemSize-1; j >= 0; j--) {
				if (item > queueArray[j]) {
					queueArray[j+1] = queueArray[j];
				} else {
					break;
				}
			}
			
			queueArray[j+1] = item;
			itemSize++;
		}
	}
	
	public int remove() {
		return queueArray[--itemSize];
	}
	
	public boolean isEmpty() {
		return itemSize == 0;
	}
	
	public boolean isFull() {
		return itemSize == maxSize;
	}

}
