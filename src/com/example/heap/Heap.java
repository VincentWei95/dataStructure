package com.example.heap;

/**
 * ����һ���������ȼ����е�һ��ʵ�ַ�ʽ
 *
 * ��������ʵ�ֵ����ȼ����д��ڵ������ǣ�ɾ����ʱ�临�Ӷ�ΪO(1)����������Ҫ�ϳ�ʱ��O(N)
 * ʹ�ö�ʵ�ֵ����ȼ����в����ɾ����ʱ�临�Ӷȶ���O(logN)
 *
 * �����������ص�Ķ�������
 * 1��������ȫ���������������һ��ڵ㲻��Ҫ�����ģ�����ÿһ������Ҷ������ģ�
 * 2������һ������ʵ��
 * 3����������ÿһ���ڵ㶼����ѵ���������ÿһ���ڵ�Ĺؼ��ֶ����ڻ��������ڵ���ӽڵ�Ĺؼ���
 *
 * �Ѳ������ڲ��ң�ֻ��ʹ���ڲ����ɾ���Ĳ����ϡ�
 *
 * �Ƴ���ɾ�����Ľڵ㣬����ڵ����Ǹ���㣬���Ƴ����������Ҫ������裺
 * 1�����߸���Ҳ��������ĵ�һ��Ԫ�أ�
 * 2�������һ���ڵ��ƶ�����λ�ã�arr[0] = arr[length - 1])
 * 3��һֱ����ɸѡ����ڵ㣬ֱ������һ���������Ľڵ�֮�£�С�����Ľڵ�֮��Ϊֹ
 * �����Ǹ��ƶ�����������Ԫ�أ����������ƶ���ǰ��������ֵС����������������ֵ������������λ�ã���ÿһ�������ж������һ������λ�ý�����
 * ÿ��λ�ý�����ǰ�ڵ㶼��Ա��������ߵ���ֵ����ʹ��һ�߽���λ�ã�
 *
 * ���룺���뵽����λ�ã�Ϊ������ѵ�������Ҫ��һЩ�������裺
 * 1�����ݲ��뵽���λ��
 * 2��һֱ����ɸѡ����ڵ㣬ֱ������һ���������Ľڵ�֮�£�С�����Ľڵ�֮��Ϊֹ�����Ƴ���ͬҲ��Ҫ��������
 *
 * Ҫ�öѵ������ʾΪһ������ҪһЩҪ�㡣�������нڵ������Ϊx����
 * 1�����ĸ��ڵ���±�Ϊ(x - 1) / 2
 * 2���������ӽڵ���±�Ϊ2 * x + 1
 * 3���������ӽڵ���±�Ϊ2 * x + 2
 */
@Deprecated
public class Heap {
    // Ҫ��������鿴����һ����ȫ�������������ٸ�������Ļ�ȡ�ڵ�Ҫ�㷽���ԱȽ�������
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
        elements[currentSize] = newNode; // �������ݲ��뵽���һ��λ��
        trickUp(currentSize++);
        return true;
    }

    public Node remove() {
        Node root = elements[0]; // ɾ�������Ǹ�λ�ã�����һ��Ԫ��
        elements[0] = elements[--currentSize]; // �����һ�������ƶ����뵽��һ��λ��
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
        int parent = (index - 1) / 2; // �õ����ڵ���±�
        Node bottom = elements[index]; // �õ��ղ��������

        // ���жԱȽ������ҵ���һ��λ�ñ��Լ�С��һ��λ�ñ��Լ����λ��
        // ������ǰ����
        while (index > 0 && elements[parent].data < bottom.data) {
            elements[index] = elements[parent];
            index = parent;
            parent = (parent - 1) / 2; // �õ���ǰ�ڵ�ĸ��ڵ�
        }
        elements[index] = bottom; // �ҵ����ʵ�λ�ò��뵽�Ǹ�λ��
    }

    private void trickDown(int index) {
        int largeChild;
        Node top = elements[index];
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1; // �õ���ǰ�ڵ�����ӽڵ�
            int rightChild = leftChild + 1; // �õ���ǰ�ڵ�����ӽڵ�

            // ���жԱȽ������ҵ���һ��λ�ñ��Լ�С��һ��λ�ñ��Լ����λ��
            // �����������
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
