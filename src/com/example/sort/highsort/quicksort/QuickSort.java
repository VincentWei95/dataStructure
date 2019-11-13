package com.example.sort.highsort.quicksort;

/*
 * ��������
 * ��һ��������ѡȡһ����׼ֵpivot��ͨ�����ֵķ�ʽ��������pivotΪ��׼��Ϊ���������֣���ߵ�С��pivotֵ���ұߵĴ���pivotֵ��
 * ͨ���ݹ�ķ�ʽ��ÿ��ִ�л��ֶ����ȡ����׼ֵ������ͨ����׼ֵ�����ٶ���ߵ�������л�������ֱ�������ٻ��֣�����һ�ߵ������������ʼ��һ������Ļ�������
 * 
 * ʱ�临�Ӷȣ�O(N*logN)
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
	
	
	// ��������
	public void execQuickSort(int left, int right) {
		if (right-left <= 0) return;
		
		int pivot = elements[right]; // ѡ�����һ����Ϊ��׼ֵ���л��ֲ���
		int partition = partitionIt(left, right, pivot); // �õ���׼ֵ������
		execQuickSort(left, partition-1); // �ݹ鷽ʽ���ϻ�ȡ����׼ֵ��������߽��л��ֽ�������ֱ����ߵ�������ɺ�ִ������ĵݹ���ұߵ�������л��ֽ�������
		execQuickSort(partition+1, right);
	}
	// ����
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
