package com.example.sort.highsort.mergesort;

/*
 * �鲢����ĺ���˼���Ƿ��Σ�recursion������һ�����ӵ������ֳ����ɸ������������
 *
 * ��������м仮�ֳ����������飬һֱ�ݹ�ذ�������ֳɸ�С�������飬ֱ������������ֻ��һ��Ԫ��
 * ���ΰ��յݹ�ķ���˳�򣬲��ϵغϲ��ź���������飬ֱ���������������˳���ź�
 * 
 * ʱ�临�Ӷȣ�O(N*logN)
 *
 * �鲢�㷨��һ�����ϵݹ�Ĺ��̣����������Ԫ�ظ�����n
 * ʱ�临�Ӷ���T(n)�ĺ�����T(n) = 2 * T(n/2) + O(n)
 *
 * ���ڹ�ģΪn�����⣬һ��Ҫ����log(n)��Ĵ�С�з�
 * ÿһ��ĺϲ����Ӷȶ���O(n)
 * ��������ĸ��ӶȾ���O(nlogn)
 *
 * �ռ临�Ӷȣ�O(n)
 *
 * ���ںϲ�n��Ԫ����Ҫ����һ����СΪn�Ķ������飬�ϲ����֮���������Ŀռ�ͻᱻ�ͷ�
 */
public class MergeSort {
	
	public MergeSort() { }

	public int[] sort(int[] arr, int low, int height) {
		if (low >= height) return null;

		// ������ֳ�����
		// �����int mid = (low + height) / 2�������д���ĺô����ܹ��������������С������
		int mid = low + (height - low) / 2;

		// ����ֻ�ǽ����鲻�ϻ���
		sort(arr, low, mid);
		sort(arr, mid + 1, height);

		// ���յ�����ϲ���������merge()ִ��
		return merge(arr, low, height, mid);
	}

	public int[] merge(int[] arr, int low, int height, int mid) {
		// ��Ϊ�Ƚϻ�ʹ�õ�ԭ�������飬������Ҫ����һ��
		int[] copy = arr.clone();
		// ��ʲôλ�ÿ�ʼ�޸�����
		int k = low;

		// ���ߵ���ʼλ��
		int i = low;
		// �Ұ�ߵ���ʼλ��
		int j = mid + 1;

		while (k <= height) {
			// ���ߵ���������ˣ�ֻ��Ҫ���Ұ�ߵ������������鼴��
			if (i > mid) {
				arr[k++] = copy[j++];
			}
			// �Ұ�ߵ���������ˣ�ֻ��Ҫ�����ߵ������������鼴��
			else if (j > height) {
				arr[k++] = copy[i++];
			}
			// �ұߵ���С����ߵ���
			else if (copy[j] < copy[i]) {
				arr[k++] = copy[j++];
			}
			// ��ߵ���С���ұߵ���
			else {
				arr[k++] = copy[i++];
			}
		}
		return arr;
	}
}
