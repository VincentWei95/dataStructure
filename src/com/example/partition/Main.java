package com.example.partition;

public class Main {
	
	public static void main(String[] args) {
		int maxSize = 16;
		Partition partition = new Partition(maxSize);
		
		for (int i = 0; i < maxSize; i++) {
			int n = (int) (Math.random() * 199);
			partition.insert(n);
		}
		
		partition.display();
		
		int pivot = 99;
		System.out.println("pivot is " + pivot);
		
		int partDex = partition.partitionIt(0, maxSize-1, pivot);
		
		System.out.println("partition is at index " + partDex);
		partition.display();
	}

}
