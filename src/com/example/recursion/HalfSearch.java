package com.example.recursion;

/*
 * �ݹ�Ķ��ַ�����
 * ��ȷǵݹ�Ķ��ַ����ң��ݹ���ַ�����Ч�ʻ���һЩ
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
				return find(data, mid+1, max); // �ݹ�
			} else {
				return find(data, min, mid-1); // �ݹ�
			}
		}
	}
	
}
