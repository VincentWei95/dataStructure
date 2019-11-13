package com.example.sort.lowsort.mergesort;

public class Main {

	public static void main(String[] args) {
		int[] arrA = { 23, 47, 81, 95 };
		int[] arrB = { 7, 14, 39, 55, 62, 74 };
		int[] arrC = new int[arrA.length+arrB.length];
		
		MergeSort sort = new MergeSort(arrA, arrB, arrC);
		int[] resultArr = sort.merge();
		for (int i = 0; i < resultArr.length; i++) {
			System.out.print(resultArr[i] + " ");
		}
	}
	
}
