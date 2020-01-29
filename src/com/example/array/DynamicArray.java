package com.example.array;

public class DynamicArray<E> {
    // 数据源
    private E[] data;
    // 指针
    private int size;

    public DynamicArray(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public DynamicArray() {
        this(10);
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 获取index索引位置的元素
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

    // 修改index索引位置的元素为e
    public void set(int index, E e) {
        if (index < 0 || index >= size) throw new IllegalArgumentException();
        data[index] = e;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(e)) return i;
        }
        return -1;
    }

    // 查找数组中是否有元素e
    public boolean contains(E e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(e)) return true;
        }
        return false;
    }

    /**
     * 在index索引的位置插入一个新元素e
     *
     * 将index往后的元素从最后到index位置，每一个元素往后移动一个位置，最终空出index位置给新元素，size指针+1
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) throw new IllegalArgumentException();

        // 如果数组已满，扩容
        if (size == data.length) resize(2 * data.length);

        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];
        data[index] = e;
        size++;
    }

    // 在所有元素前添加一个新元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 向所有元素后添加一个新元素
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 从数组中删除index位置的元素, 返回删除的元素
     *
     * 将index往后的元素从index+1位置到最后遍历，每一个元素往前移动一个位置，size指针-1
     */
    public E remove(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException();

        E ret = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        size--;
        data[size] = null;

        // 删除元素后数组长度如果为数组总容量的1/4，缩容，需要避免data.length / 2 == 0没有任何处理
        if (size == data.length / 4 && data.length / 2 != 0) resize(data.length / 2);
        return ret;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    // 将数组空间的容量变成newCapacity大小
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        // 将旧数组的元素复制到新数组中
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
