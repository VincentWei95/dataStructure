package com.example.linklist;

/**
 * ����ʵ��ջ�������ʹ��ʹ�þ�̬�����Stackʱ�临�ӶȲ��
 */
public class LinkedStackList<E> {
    private LinkedList<E> linkedList;

    public LinkedStackList() {
        linkedList = new LinkedList<>();
    }

    public void push(E e) {
        linkedList.addFirst(e);
    }

    public E pop() {
        return linkedList.removeFirst();
    }

    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(linkedList);
        return res.toString();
    }
}
