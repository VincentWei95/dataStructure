package com.example.linklist;

/*
 * ˫������
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
			last = newLink; // ���û��������ڣ����Link����firstҲ��last
		
		newLink.next = first;
		first = newLink;
	}
	
	public void insertLast(double data) {
		Link newLink = new Link(data);
		
		if (isEmpty()) { // ���û��������ڣ����Link����first
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
		System.out.println("˫�������ӡ");
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
