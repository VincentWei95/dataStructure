package com.example.linklist;

public class Main {
	
	public static void main(String[] args) {
		// 单链表
//		LinkList list = new LinkList();
//		list.insertFirst(22, 2.99);
//		list.insertFirst(44, 4.99);
//		list.insertFirst(66, 6.99);
//		list.insertFirst(88, 8.99);
//		
//		list.displayList();
		
//		while (!list.isEmpty()) {
//			Link link = list.removeFirst();
//			System.out.print("delete:");
//			link.displayLink();
//			System.out.println();
//		}
//		
//		list.displayList();
		
//		Link f = list.find(44);
//		if (f != null) {
//			System.out.println("found link with key " + f.key);
//		} else {
//			System.out.println("can't find link");
//		}
//		
//		Link d = list.remove(66);
//		if (d != null) {
//			System.out.println("delete link with key " + d.key);
//		} else {
//			System.out.println("cant delete link");
//		}
//		
//		list.displayList();
		
		// 双端链表
//		FirstLastList list = new FirstLastList();
//		list.insertFirst(22);
//		list.insertFirst(44);
//		list.insertFirst(66);
//		list.insertFirst(88);
//		
//		list.displayList();
//		
//		list.removeFirst();
//		list.removeFirst();
//		
//		list.displayList();
		
		// 有序链表
		SortedLinkList list = new SortedLinkList();
		list.insert(22, 2.99);
		list.insert(44, 4.99);
		list.insert(66, 6.99);
		list.insert(88, 8.99);
		
		list.displayList();
		
		list.removeFrist();
		
		list.displayList();
	}

}
