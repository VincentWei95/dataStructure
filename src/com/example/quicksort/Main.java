package com.example.quicksort;

public class Main {
	
	public static void main(String[] args) {
		QuickSort sort = new QuickSort(16);
		for (int i = 0; i < 16; i++) {
			int n = (int) (Math.random() * 99);
			sort.insert(n);
		}
		sort.display();
		sort.quickSort();
		sort.display();
	}

}
