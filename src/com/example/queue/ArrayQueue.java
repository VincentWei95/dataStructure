package com.example.queue;

import com.example.array.DynamicArray;

/**
 * 数组队列，先进先出（想象现实中的排队），队头删除队尾插入
 */
public class ArrayQueue<E> implements Queue<E> {
    private DynamicArray<E> array;

    public ArrayQueue(int capacity) {
        array = new DynamicArray<>(capacity);
    }

    public ArrayQueue() {
        array = new DynamicArray<>();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    // O(n)需要优化，每次删除都要将往后的其他元素往前移动一步，LoopQueue循环队列优化
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
