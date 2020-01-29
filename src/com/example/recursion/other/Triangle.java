package com.example.recursion.other;

/**
 * 三角数字序列的算法：第n个三角数字=(n^2 + n) / 2
 * 
 * 数字6的三角数字序列如下：
 * 
 * -
 * - - 
 * - - -
 * - - - -
 * - - - - -
 * - - - - - -
 * 
 * 从图可以发现，三角数字序列要计算总数值，就是从竖直列开始往下叠加6+5+4+3+2+1
 * 如果是n个三角数字序列，则为n+(n-1)+(n-2)+.....+1，即n加上第n-1个三角数字的和
 * 
 * 三角数字序列，也是数学中的数学归纳法
 */

public class Triangle {
	
	/**
	 * 输入的值为5，执行结果如下：
	 * 
	 * Entering: n = 5 
	 * Entering: n = 4 
	 * Entering: n = 3 
	 * Entering: n = 2 
	 * Entering: n = 1  
	 * returning 1    1  // 倒着往回加
	 * returning 3    1+2=3   
	 * returning 6    3+3=6
	 * returning 10   6+4=10
	 * returning 15   10+5=15
	 * triangle = 15
	 *
	 * 递归并不是高效的，但在某些情况下对执行进行了简化，不适合大数量的执行
	 * 相比的，一般会使用循环来处理大数量执行，循环比递归效率更高
	 * 
	 */
	public static int triangle(int n) {
		System.out.println("Entering: n = " + n);
		if (n == 1) { // 基值等于1时，停止递归
			System.out.println("returning 1");
			return 1;
		} else {
			int temp = n + triangle(n - 1);
			System.out.println("returning " + temp);
			return temp;
		}
	}

}
