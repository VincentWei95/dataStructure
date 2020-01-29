package com.example.linklist;

/**
 * 链表实现栈，相比起使用使用静态数组的Stack时间复杂度差不多
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
