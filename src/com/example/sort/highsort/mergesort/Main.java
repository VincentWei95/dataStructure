package com.example.sort.highsort.mergesort;

public class Main {

	public static void main(String[] args) {
		int[] arr = { 23, 47, 81, 95, 7, 14, 39, 55, 62, 74 };
		MergeSort sort = new MergeSort();
		int[] resultArr = sort.sort(arr, 0, arr.length - 1);
		for (int i = 0; i < resultArr.length; i++) {
			System.out.print(resultArr[i] + " ");
		}
	}
}
