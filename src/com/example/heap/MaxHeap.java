package com.example.heap;

import com.example.array.DynamicArray;

/**
 * 最大堆（二叉堆），数组索引从0开始
 * <p>
 * 堆是一种树，优先级队列的一种实现方式
 * <p>
 * 有序数组实现的优先级队列存在的问题是，删除的时间复杂度为O(1)，但插入需要较长时间O(N)
 * 使用堆实现的优先级队列插入和删除的时间复杂度都是O(logN)
 * <p>
 * 堆是有如下特点的二叉树：
 * 1、它是完全二叉树（除了最后一层节点不需要是满的，其他每一层从左到右都是满的）
 * 2、它用一个数组实现
 * 3、堆中树的每一个节点都满足堆的条件，即每一个节点的关键字都大于或等于这个节点的子节点的关键字
 * <p>
 * 堆不适用于查找，只能使用在插入和删除的操作上。
 * <p>
 * 移除：删除最大的节点，这个节点总是根结点，在移除根结点后就需要填补，步骤：
 * 1、移走根（也就是数组的第一个元素）
 * 2、把最后一个节点移动到根位置（arr[0] = arr[length - 1])
 * 3、一直向下筛选这个节点，直到它在一个大于它的节点之下，小于它的节点之上为止
 * （就是刚移动上来的数组元素，遍历查找移动到前面索引的值小于它，后面索引的值大于它的索引位置，在每一步查找中都会进行一次数组位置交换，
 * 每次位置交换当前节点都会对比左右两边的数值，会和大的一边交换位置）
 * <p>
 * 插入：插入到最后的位置，为了满足堆的特性需要做一些处理，步骤：
 * 1、数据插入到最后位置
 * 2、一直向上筛选这个节点，直到它在一个大于它的节点之下，小于它的节点之上为止（和移除相同也需要做交换）
 * <p>
 * 要让堆的数组表示为一棵树需要一些要点。若数组中节点的索引为x，则：
 * 1、它的父节点的下标为(x - 1) / 2
 * 2、它的左子节点的下标为2 * x + 1
 * 3、它的右子节点的下标为2 * x + 2
 */
public class MaxHeap<E extends Comparable<E>> {

    private DynamicArray<E> data;

    public MaxHeap(int capacity) {
        data = new DynamicArray<>(capacity);
    }

    public MaxHeap() {
        data = new DynamicArray<>();
    }

    public MaxHeap(E[] arr) {
        data = new DynamicArray<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--)
            siftDown(i);
    }

    // 返回堆中的元素个数
    public int size() {
        return data.getSize();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    // 向堆中添加元素
    public void add(E e) {
        // 先将待添加元素插入到数组最后一个位置
        data.addLast(e);
        // 开始上浮，传递的索引位置为刚添加的元素位置
        siftUp(data.getSize() - 1);
    }

    /**
     * 索引k和其父节点的大小对比，如果索引k的父节点元素 < 索引k的元素，位置交换，然后继续依次操作直到满足最大堆特性（左右节点的元素大小 < 父节点的元素大小）
     */
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    // 看堆中的最大元素
    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        // 最大堆的最大元素就是第一个数组位置
        return data.get(0);
    }

    // 取出堆中最大元素
    public E extractMax() {
        E ret = findMax();

        // 交换最大值和最小值后，此时最小值在树的根节点，最大值在叶子节点
        data.swap(0, data.getSize() - 1);
        // 移除最大值
        data.removeLast();
        // 最小值在根节点，为满足最大堆特性需要下沉
        siftDown(0);

        return ret;
    }

    /**
     * 索引k和其左右两个节点的大小对比，如果索引k的元素 < 索引k的左/右节点元素，索引k位置和最大节点元素位置交换，然后继续依次操作直到满足最大堆的特性（左右节点的元素大小 < 父节点的元素大小）
     */
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k); // 在此轮循环中,data[k]和data[j]交换位置
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0)
                j++;
            // data[j] 是 leftChild 和 rightChild 中的最大值

            if (data.get(k).compareTo(data.get(j)) >= 0)
                break;

            data.swap(k, j);
            k = j;
        }
    }

    // 取出堆中的最大元素，并且替换成元素e
    public E replace(E e) {

        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
