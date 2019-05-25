package com.example.linklist;

/*
 * 单链表
 */
public class LinkList {
	
	private Link first;
	
	public LinkList() {
		first = null;
	}
	
	// 将一个新的Link插入到链表头
	public void insertFirst(int key, double data) {
		Link newLink = new Link(key, data);
		newLink.next = first; // 让newLink.next指向上一个Link
		first = newLink; // newLink作为新的first
	}
	
	// 移除在链表头的Link
	public Link removeFirst() {
		Link temp = first;
		first = first.next; // 当前的first.next是指向下一个Link，把指向重新作为first则可以删除Link，断开的Link会在不定时由gc回收 
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
		
		if (current == first) { // 第一个就是要移除的Link，将first.next指向的Link重新作为first
			first = first.next;
		} else {
			previous.next = current.next; // 让current.next指向的Link给previous.next指向，则删除了current
		}
				
		return current;
	}

	public boolean isEmpty() {
		return first == null;
	}
	
	public void displayList() {
		System.out.println("单链表打印");
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}
	
}
