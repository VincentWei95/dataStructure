package com.example.recursion;

/**
 * 移除链表元素：
 *
 * 删除链表中等于给定值val的所有节点
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveLinkElement {

    public static void main(String[] args) {

    }

    private ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        // 把这里的递归函数removeElements(head.next, val)看成是一个普通函数
        // 它返回了一个节点
        ListNode res = removeElements(head.next, val);
        if (res.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }

        // head.next = removeElements(head.next, val);
        // return head.val == val ? head.next : head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
