package com.example.sort.lowsort.bubblesort;

/*
 * ð���������ڵ�������֮����жԱȣ���1λ�öԱ�2λ�ã�2λ�öԱ�3λ�ã��Դ����ơ�
 * ���������������С�������һ��������ɺ�������ֵ���������������������н������ٽ��д�������������Դ����ơ�
 * 
 * ʱ�临�ӶȶԱȣ�O(1)>O(logn)>O(n)>O(n^2)
 * 
 * ʱ�临�Ӷȣ�O(n^2)
 * ���ۺ�ʱ��ֻҪ����һ��ѭ��Ƕ����һ��ѭ�����Ϳ��Ի�������㷨��ʱ�临�Ӷ�ΪO(n^2)
 */
public class BubbleSort {
	
	private int index;
	private int[] elements;
	
	public BubbleSort(int max) {
		elements = new int[max];
		index = 0;
	}
	
	public void insert(int element) {
		elements[index] = element;
		index++;
	}
	
	public void display() {
		for (int i = 0; i < index; i++) {
			System.out.print(elements[i] + " ");
		}
		System.out.println();
	}
	
	public void sort() {
		int out, in;
		
		// ��һ��ѭ��
		// 5  3  2  4  1
		// out=4
		// in=0,elements[0]=5 > elements[1]=3
		// 3  5  2  4  1
		// in=1,elements[1]=5 > elements[2]=2
		// 3  2  5  4  1
		// in=2,elements[2]=5 > elements[3]=4
		// 3  2  4  5  1
		// in=3,elements[3]=5 > elements[4]=1
		// 3  2  4  1  5
		
		// �ڶ���ѭ��
		// 3  2  4  1  5
		// out=3
		// in=0,elements[0]=3 > elements[1]=2
		// 2  3  4  1  5
		// in=1,elements[1]=3 > elements[2]=4
		// 2  3  4  1  5
		// in=2,elements[2]=4 > elements[3]=1
		// 2  3  1  4  5
		
		// ������ѭ��
		// 2  3  1  4  5
		// out=2
		// in=0,elements[0]=2 > elements[1]=3
		// 2  3  1  4  5
		// in=1,elements[1]=3 > elements[2]=1
		// 2  1  3  4  5
		
		// ���Ĵ�ѭ��
		// 2  1  3  4  5
		// out=1
		// in=0,elements[0]=2 > elements[1]=1
		// 1  2  3  4  5
		
		// ð������
	    for (out = index - 1; out > 1; out--) { // ÿִ��һ��������Ϊ����һ����������������������н��д���
	    	for (in = 0; in < out; in++) {
	    		if (elements[in] > elements[in+1]) {
	    			int temp = elements[in];
	    			elements[in] = elements[in+1];
	    			elements[in+1] = temp;
	    		}
	    	}
	    }
	}

}
