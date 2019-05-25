package com.example.recursion;

/*
 * ��ŵ������
 * 
 * ��������A��B��C��A��Դ����������е����ݣ�B��һ���м������ṩ��������ʱ��ţ���C��Ŀ����
 * ������Ҫ����A�ϵ�����ȫ���ƶ�����C��һ��ֻ���ƶ�һ�����ݣ����ƶ���������ʱ��������ݲ��ܴ������������
 * 
 *      ��A        ��B        ��C
 *       |         |          |
 *      -|-        |          |
 *     --|--       |          |
 *    ---|---      |          |
 *   ----|----     |          |
 *  -----|-----    |          | 
 */
public class Tower {
	
	/**
	 * @param topN  ����������������Ĳ���from,inter,to���Ǳ���ģ�ֻ���ڴ�ӡ�鿴��
	 * @param from  ��Դ����������A
	 * @param inter �м�������������B
	 * @param to    Ŀ��������������C
	 */
	public static void doTower(int topN, char from, char inter, char to) {
		if (topN == 1) {
			System.out.println("Disk 1 from " + from + " to " + to);
		} else {
			doTower(topN-1, from, to, inter);
			
			System.out.println("Disk " + topN + " from " + from + " to " + to);
			
			doTower(topN-1, inter, from, to);
		}
	}

}
