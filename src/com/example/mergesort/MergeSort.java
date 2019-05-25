package com.example.mergesort;

/*
 * 归并排序，内部使用的是递归的方式
 * 相比于冒泡排序、选择排序、插入排序速度更快
 * 
 * 归并排序：三个数组，将两个无序的数组整合排序到一个数组中
 * 
 * 时间复杂度：O(N*logN)
 */
public class MergeSort {
	
	private int[] arrA; 
	private int[] arrB;
	private int[] arrC; // 数组C是空数组，用于存放最后的结果
	
	public MergeSort(int[] arrA, int[] arrB, int[] arrC) {
		this.arrA = arrA;
		this.arrB = arrB;
		this.arrC = arrC;
	}
	// 归并排序
	public int[] merge() {
		int aIndex = 0;
		int bIndex = 0;
		int cIndex = 0;
		
		 // 第一个while：沿着数组A和数组B走，比较它们的数据项，并且复制它们中较小的数组项到数组C
		while (aIndex < arrA.length && bIndex < arrB.length) {
			if (arrA[aIndex] < arrB[bIndex]) 
				arrC[cIndex++] = arrA[aIndex++];
			 else 
				arrC[cIndex++] = arrB[bIndex++];
			
			// 第二个while：处理当数组B的所有数据项都已经移除，而数组A还有剩余数据项的情况，将数组A剩余数据项复制到数组C
			while (aIndex < arrA.length)
				arrC[cIndex++] = arrA[aIndex++];
			
			// 第三个while：处理当数组A的所有数据项都已经移除，而数组B还有剩余数据项的情况，将数组B剩余数据项复制到数组C
			while(bIndex < arrB.length)
				arrC[cIndex++] = arrB[bIndex++];
				
		}
		
		return arrC;
	}

}
