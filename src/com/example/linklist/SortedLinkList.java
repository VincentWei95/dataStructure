package com.example.linklist;

/*
 * 有序链表
 */
public class SortedLinkList {

	private Link first;
	
	public SortedLinkList() {
		first = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	// 要注意插入时的链头和链尾
	public void insert(int key, double data) {
		Link newLink = new Link(key, data);
		Link previous = null;
		Link current = first;
		
		// 查找合适的位置插入
		while (current != null && key > current.key) {
			previous = current;
			current = current.next;
		}
		
		if  (previous == null) { // 链表是空的，所以插入到链头
			first = newLink;
		} else { // 上一个Link指向新的Link
			previous.next = newLink;
		}
		newLink.next = current; // 新的Link指向下一个Link
	}
	
	public Link removeFrist() {
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	public void displayList() {
		System.out.println("打印有序链表");
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}
}
