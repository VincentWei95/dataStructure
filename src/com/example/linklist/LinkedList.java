package com.example.linklist;

/**
 * ������
 * ��Ӳ�����O(n)��������������ͷ��ΪO(1)
 * ɾ��������O(n)�������ɾ������ͷ��ΪO(1)
 * ���Ĳ�����O(n)
 * ���Ҳ�����O(n)
 *
 * �������������ͷ��Ӻ�ɾ��������ʱ�临�Ӷ�ΪO(1)��������������ʵ��ջLinkedStackList
 */
public class LinkedList<E> {
    // ����ͷ�ڵ㣬ָ��ͷһ���ڵ�
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    // ��ȡ�����е�Ԫ�ظ���
    public int getSize() {
        return size;
    }

    // ���������Ƿ�Ϊ��
    public boolean isEmpty() {
        return size == 0;
    }

    // �������index(0-based)λ������µ�Ԫ��e
    // �������в���һ�����õĲ���
    public void add(int index, E e) {
        if (index < 0 || index > size) throw new IllegalArgumentException();

        // �ҵ���ӽڵ��ǰһ��λ��
        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        Node node = new Node(e); // �����ڵ�
        node.next = prev.next; // �����ڵ�ָ��ǰ��һ���ڵ�ָ��Ľڵ�
        prev.next = node; // ��һ���ڵ�ָ�������ڵ�

        size++;
    }

    // ������ͷ����µ�Ԫ��e
    public void addFirst(E e) {
        add(0, e);
    }

    // ������ĩβ����µ�Ԫ��e
    public void addLast(E e) {
        add(size, e);
    }

    // �������ĵ�index(0-based)��λ�õ�Ԫ��
    // �������в���һ�����õĲ���
    public E remove(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException();

        // �ҵ�ɾ���ڵ��ǰһ��λ��
        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        Node retNode = prev.next; // ��ɾ���Ľڵ�
        prev.next = retNode.next; // ��ɾ���ڵ����һ���ڵ�ָ��ɾ���ڵ�ָ�����һ���ڵ�
        retNode.next = null; // ��ɾ���ڵ���null
        size--;
        return (E) retNode.e;
    }

    // �������ĵ�һ��Ԫ��
    public E removeFirst() {
        return remove(0);
    }

    // �����������һ��Ԫ��
    public E removeLast() {
        return remove(size - 1);
    }

    // �޸�����ĵ�index(0-based)��λ�õ�Ԫ��Ϊe
    // �������в���һ�����õĲ���
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

    // �����������Ƿ���Ԫ��e
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
