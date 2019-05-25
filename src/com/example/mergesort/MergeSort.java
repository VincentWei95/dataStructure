package com.example.mergesort;

/*
 * �鲢�����ڲ�ʹ�õ��ǵݹ�ķ�ʽ
 * �����ð������ѡ�����򡢲��������ٶȸ���
 * 
 * �鲢�����������飬�����������������������һ��������
 * 
 * ʱ�临�Ӷȣ�O(N*logN)
 */
public class MergeSort {
	
	private int[] arrA; 
	private int[] arrB;
	private int[] arrC; // ����C�ǿ����飬���ڴ�����Ľ��
	
	public MergeSort(int[] arrA, int[] arrB, int[] arrC) {
		this.arrA = arrA;
		this.arrB = arrB;
		this.arrC = arrC;
	}
	// �鲢����
	public int[] merge() {
		int aIndex = 0;
		int bIndex = 0;
		int cIndex = 0;
		
		 // ��һ��while����������A������B�ߣ��Ƚ����ǵ���������Ҹ��������н�С�����������C
		while (aIndex < arrA.length && bIndex < arrB.length) {
			if (arrA[aIndex] < arrB[bIndex]) 
				arrC[cIndex++] = arrA[aIndex++];
			 else 
				arrC[cIndex++] = arrB[bIndex++];
			
			// �ڶ���while����������B������������Ѿ��Ƴ���������A����ʣ��������������������Aʣ��������Ƶ�����C
			while (aIndex < arrA.length)
				arrC[cIndex++] = arrA[aIndex++];
			
			// ������while����������A������������Ѿ��Ƴ���������B����ʣ��������������������Bʣ��������Ƶ�����C
			while(bIndex < arrB.length)
				arrC[cIndex++] = arrB[bIndex++];
				
		}
		
		return arrC;
	}

}
