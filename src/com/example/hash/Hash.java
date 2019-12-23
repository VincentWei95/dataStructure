package com.example.hash;

/**
 * 哈希表：将插入的数据的key哈希化后存储进数组中，该数组就是哈希表
 * 哈希化：就是缩小数组存储索引范围的计算过程，数据的key与数组长度取模操作获得
 *
 * 冲突：在哈希化过程中计算得到的数组索引下标已经有数据在该数组下标存储，就是哈希表的冲突。
 * 冲突有两种解决方案：
 * 1、开放地址法：找到数组其他空位插入数据，不再用哈希化计算得到的数组下标
 * 2、链地址法：数组内不存储数据，发生冲突时新的数据直接接到这个数组下标所指的链表中
 *
 * 开放地址法的三种处理方式：
 * 1、线性探测：在哈希计算后冲突的数组下标开始往下一步步找没有数据存储的数组下标索引，找到就将数据插入
 * 存在的问题：当数组快填满时，探测查找空白位置的时间会加长，也会导致分配不均匀，数组一部分聚集大量的数据，另一部分还很稀疏，降低性能
 *
 * 2、二次探测：在哈希计算后冲突的数组下标开始往下找没有数据存储的数组下标索引，往下找每次遇到已经有数据存储时都加大查找间隔，
 * 比如第一次查找的位置有数据，间隔就加大到4查找，再查找的位置有数据间隔就加大到9，依此类推，直到找到空白的位置将数据插入
 * 存在的问题：当数组快填满时，探测查找空白位置的间隔会超过数组长度
 *
 * 3、再哈希法：在哈希计算后冲突时，把key用不同的哈希函数再做一遍哈希化，用这个结果作为步长查找空白的数组位置
 * 第二个哈希函数必须具备如下特点：
 * ①和第一个哈希函数不同
 * stepSize = constant - (key % constant)
 * constant是质数（除了1和自身能整除的数）
 * ②不能输出0（否则没有步长算法会陷入死循环）
 * 存在的问题：要求数组的长度是一个质数，否则第二个哈希函数计算的步长将会在几个固定的值之中导致算法崩溃
 *
 * 哈希表的优缺点：
 * 优点：
 * 插入、删除、查找快速，不论哈希表中有多少数据，插入和删除只需要接近O(1)
 * 缺点：
 * 基于数组的，数组创建后难于扩展，数组被基本填满时性能下降严重
 * 适合在不需要有序遍历数据并且可以提前预测数据量大小的情况使用
 */

// 使用链地址法实现哈希表
public class Hash {
    private SortedList[] hashArray;
    private int arraySize;

    public Hash(int size) {
        arraySize = size;
        hashArray = new SortedList[arraySize];
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = new SortedList();
        }
    }

    public void displayTable() {
        for (int i = 0; i < arraySize; i++) {
            System.out.print(i + ". ");
            hashArray[i].displayList();
        }
    }

    /**
     * 哈希函数，计算数据存放的数组下标索引位置
     */
    public int hashFunc(int key) {
        return key % arraySize;
    }

    public void insert(Link link) {
        int key = link.data;
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(link);
    }

    public void delete(int key) {
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }

    public Link find(int key) {
        int hashVal = hashFunc(key);
        return hashArray[hashVal].find(key);
    }

    static class Link {
        int data;
        Link next;

        Link(int data) {
            this.data = data;
        }

        void displayLink() {
            System.out.print(data + " ");
        }
    }

    /**
     * 每个数组元素都有一个链表
     */
    static class SortedList {
        Link first;

        void insert(Link link) {
            int key = link.data;
            Link previous = null;
            Link current = first;

            while (current != null && key > current.data) {
                previous = current;
                current = current.next;
            }
            if (previous == null) {
                first = link;
            } else {
                previous.next = link;
            }
            link.next = current;
        }

        void delete(int key) {
            Link previous = null;
            Link current = first;

            while (current != null && key != current.data) {
                previous = current;
                current = current.next;
            }
            if (previous == null) {
                first = first.next;
            } else {
                previous.next = current.next;
            }
        }

        Link find(int key) {
            Link current = first;

            while (current != null && current.data <= key) {
                if (current.data == key) {
                    return current;
                }
                current = current.next;
            }

            return null;
        }

        void displayList() {
            System.out.print("List(first-->last): ");
            Link current = first;
            while (current != null) {
                current.displayLink();
                current = current.next;
            }
            System.out.println(" ");
        }
    }
}
