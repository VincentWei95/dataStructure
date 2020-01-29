package com.example.queue;

/**
 * 循环队列，维护front和tail两个指针，front指针在队头删除元素时移动，tail指针在队尾插入元素时移动
 * front==tail时队列为空；tail+1==front时队列满（具体为(tail+1)%c==front，c为capacity容量），所以我们要多空出一个空间让队列能够循环起来
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        // 需要多空出一个空间让队列能够循环起来
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        // 如果队列已满，扩容
       if ((tail + 1) % data.length == front) {
           resize(getCapacity() * 2);
       }

       data[tail] = e;
       tail = (tail + 1) % data.length; // tail指针移动
       size++;
    }

    // 优化为O(1)
    @Override
    public E dequeue() {
        if (isEmpty()) throw new UnsupportedOperationException();

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length; // front指针移动
        size--;

        // 缩容
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++)
            newData[i] = data[(i + front) % data.length];
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E getFront() {
        if (isEmpty()) throw new UnsupportedOperationException();

        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        // 因为多空出一个空间，所以需要减去这个空间才是实际的队列大小
        return data.length - 1;
    }

    // 当front==tail时队列为空
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
