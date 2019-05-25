package com.example.linklist;

/*
 * 双向链表
 */
public class TwoWayLinkList {

	private Link first;
	private Link last;
	
	public TwoWayLinkList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void insertFirst(double data) {
		Link newLink = new Link(data);
		
		if (isEmpty()) { // 链表为空
			last = newLink;
		} else {
			first.previous = newLink; // 上一个指针指向新的Link
		}
		newLink.next = first; // 新的Link指向下一个Link
		first = newLink; // 将新的Link作为链头
	}
	
	public void insertLast(double data) {
		Link newLink = new Link(data);
		
		if (isEmpty()) {
			first = newLink;
		} else {
			last.next = newLink; // 上一个Link的下一个指针指向新的Link
			newLink.previous = last; // 新的Link的上一个指针指向上一个Link
		}
		last = newLink;
	}
	
	public Link removeFirst() {
		Link temp = first;
		if (first.next == null) {
			last = null;
		} else {
			first.next.previous = null;
		}
		first = first.next;
		return temp;
	}
	
	public Link removeLast() {
		Link temp = last;
		if (first.next == null) {
			first = null;
		} else {
			last.previous.next = null;
		}
		last = last.previous;
		return temp;
	}
}
