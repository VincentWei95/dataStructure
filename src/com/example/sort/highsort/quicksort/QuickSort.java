package com.example.sort.highsort.quicksort;

/*
 * ��������Ҳ�����˷���(recursion)��˼��
 *
 * ��ԭʼ������ɸѡ�ɽ�С�ͽϴ�����������飬Ȼ��ݹ����������������
 * �ڷֳɽ�С�ͽϴ����������������У����ѡ��һ����׼ֵ��Ϊ�ؼ�
 *
 * ��������
 * ��һ��������ѡȡһ����׼ֵpivot��ͨ�����ֵķ�ʽ��������pivotΪ��׼��Ϊ���������֣���ߵ�С��pivotֵ���ұߵĴ���pivotֵ��
 * ͨ���ݹ�ķ�ʽ��ÿ��ִ�л��ֶ����ȡ����׼ֵ������ͨ����׼ֵ�����ٶ���ߵ�������л�������ֱ�������ٻ��֣�����һ�ߵ������������ʼ��һ������Ļ�������
 *
 *
 * ���������ʱ�临�Ӷȣ�O(nlogn)
 *
 * ʱ�临�Ӷȣ�T(n) = 2 * T(n/2) + O(n)
 *
 * �ѹ�ģ��СΪn������ֽ��n/2�����������⣻�ͻ�׼ֵ����n-1�αȽϣ�n-1�αȽϵĸ��Ӷ���O(n)
 *
 * ��������ʱ�临�Ӷȣ�O(n^2)
 *
 * ÿ����ѡ���׼ֵ��ʱ�򶼲���ѡ�������������������Сֵ
 * ����һ�������鳤��Ϊ1����һ������ֻ�ȸ�������1
 * ����Ϊ�˱��������������Ҫ�����ȡ��׼ֵ
 *
 * �ռ临�Ӷȣ�O(logn)
 *
 * �͹鲢����ͬ������������ÿ�εݹ�����У�ֻ��Ҫ����O(1)�Ĵ洢�ռ�����ɽ�������ʵ��ֱ�Ӷ������޸�
 * ���ݹ����Ϊlogn��������������ռ临�Ӷ���ȫȡ����ѹ��ջ�Ĵ���
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
		execQuickSort(0,  index-1);
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
	private int partitionIt(int left, int right, int pivot) {
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
	
	private void swap(int left, int right) {
		int temp = elements[left];
		elements[left] = elements[right];
		elements[right] = temp;
	}

}
