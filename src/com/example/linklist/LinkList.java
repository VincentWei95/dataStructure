package com.example.linklist;

/*
 * ������
 */
public class LinkList {
	
	private Link first;
	
	public LinkList() {
		first = null;
	}
	
	// ��һ���µ�Link���뵽����ͷ
	public void insertFirst(int key, double data) {
		Link newLink = new Link(key, data);
		newLink.next = first; // ��newLink.nextָ����һ��Link
		first = newLink; // newLink��Ϊ�µ�first
	}
	
	// �Ƴ�������ͷ��Link
	public Link removeFirst() {
		Link temp = first;
		first = first.next; // ��ǰ��first.next��ָ����һ��Link����ָ��������Ϊfirst�����ɾ��Link���Ͽ���Link���ڲ���ʱ��gc���� 
		return temp;
	}
	
	public Link find(int key) {
		Link current = first;
		
		while (current.key != key) {
			if (current.next == null) {
				return null;
			} else {
				current = current.next;
			}
		}
		
		return current;
	}
	
	public Link remove(int key) {
		Link current = first;
		Link previous = first;
		
		while (current.key != key) {
			if (current.next == null) {
				return null;
			} else {
				previous = current;
				current = current.next;
			}
		}
		
		if (current == first) { // ��һ������Ҫ�Ƴ���Link����first.nextָ���Link������Ϊfirst
			first = first.next;
		} else {
			previous.next = current.next; // ��current.nextָ���Link��previous.nextָ����ɾ����current
		}
				
		return current;
	}

	public boolean isEmpty() {
		return first == null;
	}
	
	public void displayList() {
		System.out.println("�������ӡ");
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}
	
}
