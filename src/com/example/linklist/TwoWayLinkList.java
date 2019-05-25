package com.example.linklist;

/*
 * ˫������
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
		
		if (isEmpty()) { // ����Ϊ��
			last = newLink;
		} else {
			first.previous = newLink; // ��һ��ָ��ָ���µ�Link
		}
		newLink.next = first; // �µ�Linkָ����һ��Link
		first = newLink; // ���µ�Link��Ϊ��ͷ
	}
	
	public void insertLast(double data) {
		Link newLink = new Link(data);
		
		if (isEmpty()) {
			first = newLink;
		} else {
			last.next = newLink; // ��һ��Link����һ��ָ��ָ���µ�Link
			newLink.previous = last; // �µ�Link����һ��ָ��ָ����һ��Link
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
