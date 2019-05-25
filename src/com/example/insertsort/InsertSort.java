package com.example.insertsort;

/*
 * ��������ָ��һ������Ϊ��ֵ����һ���ǵڶ�����ʼ��Ϊ��ֵ[elements[out]]�����Ի�ֵ��Ϊ�ֽ��ߣ���ֵ�Ժ�Ĭ��Ϊ���򲻴���
 * ֻ�Ի�ֵ֮ǰ�����ݽ������򣨰�����ֵ���þֲ������洢��һ�λ�ֵ��ֵ�����ݼ������ֵ�Ա�[elements[in-1]>=temp]��
 * ������������洢������[in]��ֵ���Ǳ���һ��ֵ���ǣ�ֱ��������
 * ʣ�µĿ�λ���ɻ�ֵ����[elements[in]=temp]
 *		
 * ��˵��ȷ�ϻ�ֵ�����ѭ���ڵ������ڲ�ѭ���Ի�ֵΪ�ֽ����ڵݼ�
 * 
 * ʱ�临�Ӷȣ�O(n^2)����ð�������һ������ѡ�������Կ�
 */
public class InsertSort {
	
	private int index;
	private int[] elements;
	
	public InsertSort(int max) {
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
		int in, out;
		
		// ��һ��ѭ��
		// 5  3  2  4  1
		// out=1
		//   in
		//   temp
		// 5  3  2  4  1
		// in=1,elements[0]=5 >= 3
		//    5  2  4  1  in=0
		// 3  5  2  4  1
		
		// �ڶ���ѭ��
		// 3  5  2  4  1
		// out=2
		//       in
		//       temp
		// 3  5  2  4  1
		// in=2, elements[1]=5 >= 2
		// 3     5  4  1   in=1
		// in=1,elements[0]=3 >= 2
		//    3  5  4  1   in=0
		// 2  3  5  4  1
		
		// ������ѭ��
		// 2  3  5  4  1
		// out=3
		//          in
		//          temp
		// 2  3  5  4  1
		// in=3,elements[2]=5 >= 4
		// 2  3     5  1   in=2
		// in=2,elements[1]=3 >= 5
		// 2  3  4  5  1
		
		// ���Ĵ�ѭ��
		// 2  3  4  5  1
		// out=4
		//             in
		//             temp
		// 2  3  4  5  1
		// in=4,elements[3]=5 >= 1
		// 2  3  4     5   in=3
		// in=3,elements[2]=4 >= 1
		// 2  3     4  5   in=2
		// in=2,elements[1]=3 >= 1
		// 2     3  4  5   in=1
		// in=1,elements[0]=2 >= 1
		//    2  3  4  5   in=0
		// 1  2  3  4  5
		
		// ��������ָ��һ������Ϊ��ֵ
		//��һ���ǵڶ�����ʼ��Ϊ��ֵ[elements[out]]�����Ի�ֵ��Ϊ�ֽ��ߣ��ݼ������ֵ�Ա�[elements[in-1]>=temp]��
		// ������������洢������[in]��ֵ���Ǳ���һ��ֵ���ǣ�ֱ������
		// ʣ�µĿ�λ���ɻ�ֵ����[elements[in]=temp]
		
		// ȷ�ϻ�ֵ�����ѭ���ڵ������ڲ�ѭ���Ի�ֵΪ�ֽ����ڵݼ�
		
		// ��������
		for (out = 1; out < index; out++) {
			int temp = elements[out]; // ��ֵ
			in = out; // �ݼ�����
			while (in > 0 && elements[in-1] >= temp) { // ��ֵΪ�ֽ��ߣ���ֵ֮ǰ��ÿһ��ֵ���ֵ���жԱȣ�����������
				elements[in] = elements[in-1];
				--in;
			}
			elements[in] = temp;
		}
	}
	
	public void sorts() {
		int out, in;
		for (out = 1; out < index; out++) {
			int temp = elements[out];
			in = out;
			for (;in > 0 && elements[in-1] >= temp ; --in) {
				elements[in] = elements[in-1];
			}
			elements[in] = temp;
		}
	}

}
