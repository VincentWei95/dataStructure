package com.example.queue;

/**
 * ѭ�����У�ά��front��tail����ָ�룬frontָ���ڶ�ͷɾ��Ԫ��ʱ�ƶ���tailָ���ڶ�β����Ԫ��ʱ�ƶ�
 * front==tailʱ����Ϊ�գ�tail+1==frontʱ������������Ϊ(tail+1)%c==front��cΪcapacity����������������Ҫ��ճ�һ���ռ��ö����ܹ�ѭ������
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        // ��Ҫ��ճ�һ���ռ��ö����ܹ�ѭ������
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
        // �����������������
       if ((tail + 1) % data.length == front) {
           resize(getCapacity() * 2);
       }

       data[tail] = e;
       tail = (tail + 1) % data.length; // tailָ���ƶ�
       size++;
    }

    // �Ż�ΪO(1)
    @Override
    public E dequeue() {
        if (isEmpty()) throw new UnsupportedOperationException();

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length; // frontָ���ƶ�
        size--;

        // ����
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
        // ��Ϊ��ճ�һ���ռ䣬������Ҫ��ȥ����ռ����ʵ�ʵĶ��д�С
        return data.length - 1;
    }

    // ��front==tailʱ����Ϊ��
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
