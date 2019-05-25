package com.example.halfsearch;

public class Main {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8,  9, 10 };
		System.out.println(halfSearch2(arr, 7));
	}
	
	private static int halfSearch(int[] arr, int data) {
		int min = 0;
		int max = arr.length - 1;
		
		while (min <= max) {
			int mid = (min + max) / 2;
			
			if (arr[mid] > data) {
				max = mid - 1;
			} else if (arr[mid] < data) {
				min = mid + 1;
			} else {
				return mid;
			}
			
		}
		return -1;
	}
	// 二分法查找
	private static int halfSearch2(int[] arr, int data) {
		int min = 0;
		int max = arr.length - 1;
		int mid = (min + max) / 2;
		
		while (arr[mid] != data) {
			if (arr[mid] > data) {
				max = mid - 1;
			} else if (arr[mid] < data) {
				min = mid + 1;
			}
			
			if (min > max)
				return -1;
			
			mid = (min + max) / 2;
		}
		return mid;
	}
	
}
