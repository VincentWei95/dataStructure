package com.example.tree;

public class Node {
	
	public int key;
	public int data;
	public Node lefeNode; // ��ڵ�
	public Node rightNode; // �ҽڵ�
	
	public Node(int key, int data) {
		this.key = key;
		this.data = data;
	}

	public void displayNode() {
		System.out.print("{");
		System.out.print(key);
		System.out.print(", ");
		System.out.print(data);
		System.out.print("}");
	}
	
}
