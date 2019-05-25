package com.example.queue;

/*
 * 优先级队列，比如按数值最小的为最高优先级，则放在队头，优先级最低放在对尾
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
		
		if (itemSize == 0) { // 队列没有数据，直接添加
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
