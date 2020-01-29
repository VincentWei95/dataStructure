package com.example.recursion.other;

/**
 * �����������е��㷨����n����������=(n^2 + n) / 2
 * 
 * ����6�����������������£�
 * 
 * -
 * - - 
 * - - -
 * - - - -
 * - - - - -
 * - - - - - -
 * 
 * ��ͼ���Է��֣�������������Ҫ��������ֵ�����Ǵ���ֱ�п�ʼ���µ���6+5+4+3+2+1
 * �����n�������������У���Ϊn+(n-1)+(n-2)+.....+1����n���ϵ�n-1���������ֵĺ�
 * 
 * �����������У�Ҳ����ѧ�е���ѧ���ɷ�
 */

public class Triangle {
	
	/**
	 * �����ֵΪ5��ִ�н�����£�
	 * 
	 * Entering: n = 5 
	 * Entering: n = 4 
	 * Entering: n = 3 
	 * Entering: n = 2 
	 * Entering: n = 1  
	 * returning 1    1  // �������ؼ�
	 * returning 3    1+2=3   
	 * returning 6    3+3=6
	 * returning 10   6+4=10
	 * returning 15   10+5=15
	 * triangle = 15
	 *
	 * �ݹ鲢���Ǹ�Ч�ģ�����ĳЩ����¶�ִ�н����˼򻯣����ʺϴ�������ִ��
	 * ��ȵģ�һ���ʹ��ѭ�������������ִ�У�ѭ���ȵݹ�Ч�ʸ���
	 * 
	 */
	public static int triangle(int n) {
		System.out.println("Entering: n = " + n);
		if (n == 1) { // ��ֵ����1ʱ��ֹͣ�ݹ�
			System.out.println("returning 1");
			return 1;
		} else {
			int temp = n + triangle(n - 1);
			System.out.println("returning " + temp);
			return temp;
		}
	}

}
