package com.example.zhishu;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		ZhiShu zhiShu = new ZhiShu(100);
		List<Integer> list = zhiShu.getZhishuList();
		for (Integer in : list) {
			System.out.print(in + " ");
		}
	}
	
}
