package com.example.zhishu;

import java.util.ArrayList;
import java.util.List;

/*
 * ������һ������1����Ȼ��������1��������Ա�������������Ȼ������������������Ϊ����
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
			// ÿ�ν����ѭ��������2��ʼѭ���������СΪֹ���������Χ�����û���ܹ�������������������Ϊ����
			for (int j = 2; j < i; j++) { 
				if (i % j == 0) { // �ܱ�����������������
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
