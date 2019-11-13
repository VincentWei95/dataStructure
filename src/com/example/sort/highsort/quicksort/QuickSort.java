package com.example.sort.highsort.quicksort;

/*
 * 快速排序：
 * 在一个数组中选取一个基准值pivot，通过划分的方式将数组以pivot为基准分为左右两部分，左边的小于pivot值，右边的大于pivot值，
 * 通过递归的方式，每次执行划分都会获取到基准值索引，通过基准值索引再对左边的数组进行划分排序，直到不能再划分，则这一边的排序结束，开始另一边数组的划分排序
 * 
 * 时间复杂度：O(N*logN)
 */
public class QuickSort {
	
	private int index;
	private int[] elements;
	
	public QuickSort(int max) {
		elements = new int[max];
		index = 0;
	}
	
	public void insert(int element) {
		elements[index] = element;
		index++;
	}
	
	public void display() {
		System.out.print("A=");
		for (int i = 0; i < index;i ++) {
			System.out.print(elements[i] + " ");
		}
		System.out.println();
	}
	
	public void quickSort() {
		execQuickSort(0, index-1);
	}
	
	
	// 快速排序
	public void execQuickSort(int left, int right) {
		if (right-left <= 0) return;
		
		int pivot = elements[right]; // 选择最后一个作为基准值进行划分操作
		int partition = partitionIt(left, right, pivot); // 拿到基准值的索引
		execQuickSort(left, partition-1); // 递归方式不断获取到基准值对数组左边进行划分交换排序，直到左边的排序完成后，执行下面的递归对右边的数组进行划分交换排序
		execQuickSort(partition+1, right);
	}
	// 划分
	public int partitionIt(int left, int right, int pivot) {
		int leftPtr = left-1; 
		int rightPtr = right;
		while (true) {
			while (elements[++leftPtr] < pivot)
				;
			while (rightPtr > 0 && elements[--rightPtr] > pivot)
				;
			if (leftPtr >= rightPtr) break;
			
			swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right);
		return leftPtr;
	}
	
	public void swap(int left, int right) {
		int temp = elements[left];
		elements[left] = elements[right];
		elements[right] = temp;
	}

}
