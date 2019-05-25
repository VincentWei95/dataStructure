package com.example.recursion;

/*
 * 汉诺塔问题
 * 
 * 有三座塔A，B，C，A是源塔存放这所有的数据，B是一个中间塔（提供个数据临时存放），C是目标塔
 * 现在需要将塔A上的数据全部移动到塔C，一次只能移动一个数据，且移动到其他塔时上面的数据不能大于下面的数据
 * 
 *      塔A        塔B        塔C
 *       |         |          |
 *      -|-        |          |
 *     --|--       |          |
 *    ---|---      |          |
 *   ----|----     |          |
 *  -----|-----    |          | 
 */
public class Tower {
	
	/**
	 * @param topN  塔的数据量（下面的参数from,inter,to不是必须的，只用于打印查看）
	 * @param from  塔源，这里是塔A
	 * @param inter 中间塔，这里是塔B
	 * @param to    目标塔，这里是塔C
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
