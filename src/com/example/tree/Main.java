package com.example.tree;

public class Main {
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.insert(50, 15);
		tree.insert(25, 12);
		tree.insert(75, 17);
		tree.insert(12, 15);
		tree.insert(37, 12);
		tree.insert(43, 17);
		tree.insert(30, 15);
		tree.insert(33, 12);
		tree.insert(87, 17);
		tree.insert(93, 15);
		tree.insert(97, 15);
		
		System.out.println(tree.remove(75));
		Node f = tree.find(75);
		if (f != null) {
			System.out.println("Found the Node with key 75, data:" + f.data);
		} else {
			System.out.println("Not Found");
		}
	}

}
