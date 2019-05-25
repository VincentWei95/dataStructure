package com.example.recursion;

/*
 * 递归的二分法查找
 * 相比非递归的二分法查找，递归二分法查找效率会慢一些
 */
public class HalfSearch {

	private int[] arr;
	
	public HalfSearch(int[] arr) {
		this.arr = arr;
	}
	
	public int find(int data, int min, int max) {
		int mid = (min + max) / 2;
		
		if (arr[mid] == data) {
			return mid;
		} else if (min > max) {
			return arr.length;
		} else {
			if (arr[mid] < data) {
				return find(data, mid+1, max); // 递归
			} else {
				return find(data, min, mid-1); // 递归
			}
		}
	}
	
}
