package com.example.tree;

public class Node {
	
	public int key;
	public int data;
	public Node lefeNode; // 左节点
	public Node rightNode; // 右节点
	
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
