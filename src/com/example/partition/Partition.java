package com.example.partition;

/*
 * ���֣����������ʹ�ã���������ѡȡһ����ֵ��Ϊ��׼ֵpivot���������б�pivot������ݷ�����ߣ���pivotС�����ݷ����ұ�
 */
public class Partition {

	private int index;
	private int[] elements;
	
	public Partition(int max) {
		elements = new int[max];
		index = 0;
	}
	
	public void insert(int element) {
		elements[index++] = element;
	}
	
	public void display() {
		System.out.print("A = ");
		for (int i = 0; i < index; i++) 
			System.out.print(elements[i] + " ");
		System.out.println();
	}
	// ����
	public int partitionIt(int left, int right, int pivot) {
		int leftPtr = left - 1; // ��ָ�룬���left=0������ָ������������
		int rightPtr = right - 1; // ��ָ�룬���right=arr.length-1, ����ָ����������ұ�
		
		// Ч�����Ȼ�׼ֵpivotС�����ݷ�����ߣ���pivot��ķ����ұ�
		while (true) {
			while (leftPtr < right && elements[++leftPtr] < pivot) // ��pivotС��������
				;
			while (rightPtr > left && elements[--rightPtr] > pivot) // ��pivot�󣬲�����
				;
			
			if (leftPtr >= rightPtr) // ��������ָ���غϱ�ʾ�Ѿ�����������ѭ�� 
				break;
			
			swap(leftPtr, rightPtr); // ��������ָ���whileѭ�����õ���leftPtr��pivot���������rightPtr��pivotС���������������ݽ���
		}
		return leftPtr;
	}
	
	public void swap(int leftPtr, int rightPtr) {
		int temp = elements[leftPtr];
		elements[leftPtr] = elements[rightPtr];
		elements[rightPtr] = temp;
	}
}
