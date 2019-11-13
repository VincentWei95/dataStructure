package com.example.sort.lowsort.selectsort;

/*
 * 选择排序，排序选定第一个与所有数值进行排序，如1位置对比2位置，1位置对比3位置，以此类推。
 * 假设排序需求是从小到大，则第一次排序完成后，最小的一个会在最左边，在往后的排序中将不会进行处理，它的下一个位置会与往后数值排序，以此类推。
 * 
 * 时间复杂度：O(n^2)，但比冒泡排序快，因为只进行了一次交换
 */
public class SelectSort {
	
	private int index;
	private int[] elements;
	
	public SelectSort(int max) {
		elements = new int[max];
		index = 0;
	}
	
	public void insert(int element) {
		elements[index] = element;
		index++;
	}
	
	public void display() {
		for (int i = 0; i < index; i++) {
			System.out.print(elements[i] + " ");
		}
		System.out.println();
	}
	
	// 选择排序
	public void sort() {
		int out, in, min;
		
		for (out = 0; out < index - 1; out++) {
			min = out; // 初始化角标
			
			for (in = out + 1; in < index; in++) {
				if (elements[min] > elements[in]) 
					min = in;	// 只交换角标
			}
			
			// 进行一次整体循环，只进行一次交换操作
			if (min != out) {
				int temp = elements[out];
				elements[out] = elements[min];
				elements[min] = temp;
			}
		}
	}

}
