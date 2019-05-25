package com.example.linklist;

/*
 * ��������
 */
public class SortedLinkList {

	private Link first;
	
	public SortedLinkList() {
		first = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	// Ҫע�����ʱ����ͷ����β
	public void insert(int key, double data) {
		Link newLink = new Link(key, data);
		Link previous = null;
		Link current = first;
		
		// ���Һ��ʵ�λ�ò���
		while (current != null && key > current.key) {
			previous = current;
			current = current.next;
		}
		
		if  (previous == null) { // �����ǿյģ����Բ��뵽��ͷ
			first = newLink;
		} else { // ��һ��Linkָ���µ�Link
			previous.next = newLink;
		}
		newLink.next = current; // �µ�Linkָ����һ��Link
	}
	
	public Link removeFrist() {
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	public void displayList() {
		System.out.println("��ӡ��������");
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}
}
