package com.example.heap;

/**
 * 堆是一种树，优先级队列的一种实现方式
 *
 * 有序数组实现的优先级队列存在的问题是，删除的时间复杂度为O(1)，但插入需要较长时间O(N)
 * 使用堆实现的优先级队列插入和删除的时间复杂度都是O(logN)
 *
 * 堆是有如下特点的二叉树：
 * 1、它是完全二叉树（除了最后一层节点不需要是满的，其他每一层从左到右都是满的）
 * 2、它用一个数组实现
 * 3、堆中树的每一个节点都满足堆的条件，即每一个节点的关键字都大于或等于这个节点的子节点的关键字
 *
 * 堆不适用于查找，只能使用在插入和删除的操作上。
 *
 * 移除：删除最大的节点，这个节点总是根结点，在移除根结点后就需要填补，步骤：
 * 1、移走根（也就是数组的第一个元素）
 * 2、把最后一个节点移动到根位置（arr[0] = arr[length - 1])
 * 3、一直向下筛选这个节点，直到它在一个大于它的节点之下，小于它的节点之上为止
 * （就是刚移动上来的数组元素，遍历查找移动到前面索引的值小于它，后面索引的值大于它的索引位置，在每一步查找中都会进行一次数组位置交换，
 * 每次位置交换当前节点都会对比左右两边的数值，会和大的一边交换位置）
 *
 * 插入：插入到最后的位置，为了满足堆的特性需要做一些处理，步骤：
 * 1、数据插入到最后位置
 * 2、一直向上筛选这个节点，直到它在一个大于它的节点之下，小于它的节点之上为止（和移除相同也需要做交换）
 *
 * 要让堆的数组表示为一棵树需要一些要点。若数组中节点的索引为x，则：
 * 1、它的父节点的下标为(x - 1) / 2
 * 2、它的左子节点的下标为2 * x + 1
 * 3、它的右子节点的下标为2 * x + 2
 */
@Deprecated
public class Heap {
    // 要把这个数组看成是一个完全二叉树来处理，再根据上面的获取节点要点方法对比交换操作
    private Node[] elements;
    private int currentSize;
    private int maxSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        elements = new Node[maxSize];
    }

    public boolean insert(int key) {
        if (currentSize == maxSize) return false;
        Node newNode = new Node(key);
        elements[currentSize] = newNode; // 将新数据插入到最后一个位置
        trickUp(currentSize++);
        return true;
    }

    public Node remove() {
        Node root = elements[0]; // 删除的总是根位置，即第一个元素
        elements[0] = elements[--currentSize]; // 将最后一个数据移动插入到第一个位置
        trickDown(0);
        return root;
    }

    public boolean change(int index, int newValue) {
        if (index < 0 || index >= currentSize) return false;

        int oldValue = elements[index].data;
        elements[index].data = newValue;

        if (oldValue < newValue) {
            trickUp(index);
        } else {
            trickDown(index);
        }
        return true;
    }

    private void trickUp(int index) {
        int parent = (index - 1) / 2; // 拿到父节点的下标
        Node bottom = elements[index]; // 拿到刚插入的数据

        // 进行对比交换，找到上一个位置比自己小下一个位置比自己大的位置
        // 数组往前遍历
        while (index > 0 && elements[parent].data < bottom.data) {
            elements[index] = elements[parent];
            index = parent;
            parent = (parent - 1) / 2; // 拿到当前节点的父节点
        }
        elements[index] = bottom; // 找到合适的位置插入到那个位置
    }

    private void trickDown(int index) {
        int largeChild;
        Node top = elements[index];
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1; // 拿到当前节点的左子节点
            int rightChild = leftChild + 1; // 拿到当前节点的右子节点

            // 进行对比交换，找到上一个位置比自己小下一个位置比自己打的位置
            // 数组往后遍历
            if (rightChild < currentSize && elements[leftChild].data < elements[rightChild].data) {
                largeChild = rightChild;
            } else {
                largeChild = leftChild;
            }

            if (top.data >= elements[largeChild].data) break;

            elements[index] = elements[largeChild];
            index = largeChild;
        }
        elements[index] = top;
    }

    public void displayHeap() {
        System.out.print("heapArray: ");
        for (int m = 0; m < currentSize; m++) {
            if (elements[m] != null) {
                System.out.print(elements[m].data + " ");
            } else {
                System.out.print("--");
            }
        }
        System.out.println();

        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "..........................";
        System.out.println(dots + dots);

        while (currentSize > 0) {
            if (column == 0) {
                for (int k = 0; k < nBlanks; k++) {
                    System.out.print(' ');
                }
            }
            System.out.print(elements[j].data);
            if (++j == currentSize) break;

            if (++column == itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else {
                for (int k = 0; k < nBlanks * 2 - 2; k++) {
                    System.out.print(' ');
                }
            }
        }
        System.out.println("\n" + dots + dots);
    }

    private static class Node {
        int data;

        Node(int data) {
            this.data = data;
        }
    }
}
