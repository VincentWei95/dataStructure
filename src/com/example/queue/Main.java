package com.example.queue;

public class Main {
	
	public static void main(String[] args) {
//		Queue queue = new Queue(5);
//		
//		queue.insert(10);
//		queue.insert(20);
//		queue.insert(30);
//		queue.insert(40);
//		
//		queue.remove();
//		queue.remove();
//		queue.remove();
//		
//		queue.insert(50);
//		queue.insert(60);
//		queue.insert(70);
//		queue.insert(80);
//		
//		while (!queue.isEmpty()) {
//			int n = queue.remove();
//			System.out.print(n);
//			System.out.println(" ");
//		}
//		System.out.println("");
		
		PriorityQueue queue = new PriorityQueue(5);
		
		queue.insert(30);
		queue.insert(50);
		queue.insert(10);
		queue.insert(40);
		queue.insert(20);
		
		while (!queue.isEmpty()) {
			int item = queue.remove();
			System.out.print(item + " ");
		}
		System.out.println();
	}

}
