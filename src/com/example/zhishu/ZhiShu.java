package com.example.zhishu;

import java.util.ArrayList;
import java.util.List;

/*
 * 质数是一个大于1的自然数，除了1和自身可以被整除，其他自然数不能整除的数，则为质数
 */
public class ZhiShu {

	private int range;
	private List<Integer> list;
	
	public ZhiShu(int range) {
		this.range = range;
	}
	
	public List<Integer> getZhishuList() {
		list = new ArrayList<>();
		
		for (int i = 2; i <= range; i++) {
			boolean flag = true;
			// 每次进入该循环，都从2开始循环到自身大小为止，在这个范围内如果没有能够被自身整除的数，则为质数
			for (int j = 2; j < i; j++) { 
				if (i % j == 0) { // 能被整除，即不是质数
					flag = false;
					break;
				}
			}
			
			if (flag) {
				list.add(i);
			}
		}
		
		
		return list;
	}
	
}
