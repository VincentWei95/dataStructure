package com.example.array;

public class DynamicArray<E> {
    // ����Դ
    private E[] data;
    // ָ��
    private int size;

    public DynamicArray(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public DynamicArray() {
        this(10);
    }

    // ��ȡ���������
    public int getCapacity() {
        return data.length;
    }

    // ��ȡ�����е�Ԫ�ظ���
    public int getSize() {
        return size;
    }

    // ���������Ƿ�Ϊ��
    public boolean isEmpty() {
        return size == 0;
    }

    // ��ȡindex����λ�õ�Ԫ��
    public E get(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException();
        return data[index];
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    // �޸�index����λ�õ�Ԫ��Ϊe
    public void set(int index, E e) {
        if (index < 0 || index >= size) throw new IllegalArgumentException();
        data[index] = e;
    }

    // ����������Ԫ��e���ڵ����������������Ԫ��e���򷵻�-1
    public int find(E e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(e)) return i;
        }
        return -1;
    }

    // �����������Ƿ���Ԫ��e
    public boolean contains(E e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(e)) return true;
        }
        return false;
    }

    /**
     * ��index������λ�ò���һ����Ԫ��e
     *
     * ��index�����Ԫ�ش����indexλ�ã�ÿһ��Ԫ�������ƶ�һ��λ�ã����տճ�indexλ�ø���Ԫ�أ�sizeָ��+1
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) throw new IllegalArgumentException();

        // �����������������
        if (size == data.length) resize(2 * data.length);

        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];
        data[index] = e;
        size++;
    }

    // ������Ԫ��ǰ���һ����Ԫ��
    public void addFirst(E e) {
        add(0, e);
    }

    // ������Ԫ�غ����һ����Ԫ��
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * ��������ɾ��indexλ�õ�Ԫ��, ����ɾ����Ԫ��
     *
     * ��index�����Ԫ�ش�index+1λ�õ���������ÿһ��Ԫ����ǰ�ƶ�һ��λ�ã�sizeָ��-1
     */
    public E remove(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException();

        E ret = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        size--;
        data[size] = null;

        // ɾ��Ԫ�غ����鳤�����Ϊ������������1/4�����ݣ���Ҫ����data.length / 2 == 0û���κδ���
        if (size == data.length / 4 && data.length / 2 != 0) resize(data.length / 2);
        return ret;
    }

    // ��������ɾ����һ��Ԫ��, ����ɾ����Ԫ��
    public E removeFirst() {
        return remove(0);
    }

    // ��������ɾ�����һ��Ԫ��, ����ɾ����Ԫ��
    public E removeLast() {
        return remove(size - 1);
    }

    // ��������ɾ��Ԫ��e
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    // ������ռ���������newCapacity��С
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        // ���������Ԫ�ظ��Ƶ���������
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
