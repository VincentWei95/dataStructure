package com.example.linklist;

public class Link {
	
	public int key;
	public double data;
	public Link next; // 指向下一个链指针
	public Link previous; // 指向上一个链指针（用于双向链表）
	
	public Link(int key, double data) {
		this.key = key;
		this.data = data;
	}
	
	public Link(double data) {
		this.data = data;
	}
	
	public void displayLink() {
		System.out.println("{" + key + "," + data + "}");
	}
	
	public void displayData() {
		System.out.println("{" + data + "}");
	}

}
