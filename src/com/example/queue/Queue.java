package com.example.queue;

public interface Queue<E> {
    void enqueue(E e);
    E dequeue();
    E getFront();
    int getSize();
    boolean isEmpty();
}
