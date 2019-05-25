package com.example.linklist;

/*
 * 双端链表
 */
public class DoubleEndLinkList {

	private Link first;
	private Link last;
	
	public DoubleEndLinkList() {
		first = null;
		last = null;
	}
	
	public void insertFirst(double data) {
		Link newLink = new Link(data);
		
		if (isEmpty())
			last = newLink; // 如果没有链表存在，则该Link既是first也是last
		
		newLink.next = first;
		first = newLink;
	}
	
	public void insertLast(double data) {
		Link newLink = new Link(data);
		
		if (isEmpty()) { // 如果没有链表存在，则该Link就是first
			first = newLink;
		} else {
			last.next = newLink;
		}
		
		last = newLink;
	}
	
	public Link removeFirst() {
		Link temp = first;
		if (first.next == null)
			last = null;
		first = first.next;
		return temp;
	}
	
	public void displayList() {
		System.out.println("双端链表打印");
		Link current = first;
		
		while (current.next != null) {
			current.displayData();
			current = current.next;
		}
		System.out.println();
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
}
