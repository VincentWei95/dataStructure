package com.example.recursion;

/*
 * �׳�
 */
public class Factorial {
	
	
	/**
	 * �����ֵΪ5��ִ�н�����£�
	 * 
	 * Entering: n = 5 
	 * Entering: n = 4 
	 * Entering: n = 3 
	 * Entering: n = 2 
	 * Entering: n = 1  
	 * returning 1    1  // �������ؼ�
	 * returning 3    1*2=2   
	 * returning 6    2*3=6
	 * returning 10   6*4=24
	 * returning 15   24*5=120
	 * triangle = 15
	 * 
	 */
	public static int factorial(int n) {
		System.out.println("Entering: n = " + n);
		if (n == 0) { // ��ֵ����ʱ��ֹͣ�ݹ飨�����������еĻ�ֵΪ1��
			System.out.println("returning 1");
			return 1;
		} else {
			int temp = n * factorial(n - 1);
			System.out.println("returning " + temp);
			return temp;
		}
	}

}
