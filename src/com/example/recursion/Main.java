package com.example.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int number;

	public static void main(String[] args) {
		// 三角数字序列、阶乘
//		System.out.println("Enter a number: ");
//		try {
//			number = getInt();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		int result = Triangle.triangle(number);
//		int result = Factorial.factorial(number);
//		System.out.println("triangle = " + result);
		
		// 递归二分法查找
//		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8,  9, 10 };
//		HalfSearch halfSearch = new HalfSearch(arr);
//		System.out.println(halfSearch.find(8, 0, arr.length));
		
		// 汉诺塔问题
		Tower.doTower(3, 'A', 'B', 'C');
	}


	public static String getString() throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String s = bufferedReader.readLine();
		return s;
	}

	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}
}
