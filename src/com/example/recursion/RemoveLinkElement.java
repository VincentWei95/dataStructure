package com.example.recursion;

public class RemoveLinkElement {

    public static void main(String[] args) {

    }

    private ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        // ������ĵݹ麯��removeElements(head.next, val)������һ����ͨ����
        // ��������һ���ڵ�
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
