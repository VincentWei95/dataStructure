package com.example.queue;

/**
 * 链表实现队列
 *
 * 两个链表指针head和tail，队头出队节点head指针维护，队尾插入节点tail指针维护
 *
 * 数组队列ArrayQueue内部实现是数组，出队操作要将往后的数组元素往前移动导致时间复杂度为O(n)，所以使用链表队列是很好的解决方案
 */
public class LinkedListQueue<E> implements Queue<E> {
    private Node head;
    private Node tail;
    private int size;

    // 时间复杂度O(1)
    @Override
    public void enqueue(E e) {
        // 如果队尾为null，说明队列是空的
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        }
        // 队列不是空的
        else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    // 时间复杂度O(1)
    @Override
    public E dequeue() {
        if (isEmpty()) throw new IllegalArgumentException();

        Node retNode = head; // 将当前队头节点拿出来
        head = head.next; // 队头的下一个节点作为新的队头
        retNode.next = null; // 将旧的队头置null

        // 如果队列空了，tail也置null
        if (head == null) tail = null;

        size--;
        return (E) retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) throw new IllegalArgumentException();

        return (E) head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
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
