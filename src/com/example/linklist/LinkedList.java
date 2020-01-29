package com.example.linklist;

/**
 * 单链表
 * 添加操作：O(n)，如果是添加链表头则为O(1)
 * 删除操作：O(n)，如果是删除链表头则为O(1)
 * 更改操作：O(n)
 * 查找操作：O(n)
 *
 * 根据链表对链表头添加和删除操作的时间复杂度为O(1)，可以用链表来实现栈LinkedStackList
 */
public class LinkedList<E> {
    // 虚拟头节点，指向头一个节点
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作
    public void add(int index, E e) {
        if (index < 0 || index > size) throw new IllegalArgumentException();

        // 找到添加节点的前一个位置
        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        Node node = new Node(e); // 新增节点
        node.next = prev.next; // 新增节点指向当前上一个节点指向的节点
        prev.next = node; // 上一个节点指向新增节点

        size++;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
        add(0, e);
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }

    // 获得链表的第index(0-based)个位置的元素
    // 在链表中不是一个常用的操作
    public E remove(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException();

        // 找到删除节点的前一个位置
        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        Node retNode = prev.next; // 被删除的节点
        prev.next = retNode.next; // 被删除节点的上一个节点指向被删除节点指向的下一个节点
        retNode.next = null; // 被删除节点置null
        size--;
        return (E) retNode.e;
    }

    // 获得链表的第一个元素
    public E removeFirst() {
        return remove(0);
    }

    // 获得链表的最后一个元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 修改链表的第index(0-based)个位置的元素为e
    // 在链表中不是一个常用的操作
    public E get(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException();

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return (E) cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) throw new IllegalArgumentException();

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.e = e;
    }

    // 查找链表中是否有元素e
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) return true;
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    private static class Node<E> {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
