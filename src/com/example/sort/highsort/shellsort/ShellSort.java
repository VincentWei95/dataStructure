package com.example.sort.highsort.shellsort;

/*
 * ϣ������
 * ϣ�������ǻ��ڲ�������ģ���ͬ�ĵط����ڣ�ϣ���������������жԱȼ����������Щ�м����Ԫ���н��в������򣬴Ӷ�ʹ�������ܴ��ȵ��ƶ�
 * ����Щ�������Ź�һ�����ϣ�������㷨��С������ļ�����������˽��У����������Ϊ1������
 *
 * ʱ�临�Ӷȣ�O(N*(logN)^2)
 * �����ڹ�������ݣ���Ȼ�����ʱ�临�Ӷ�ΪO(n^2)
 */
public class ShellSort {
    private int index;
    private int[] elements;

    public ShellSort(int max) {
        elements = new int[max];
        index = 0;
    }

    public void insert(int element) {
        elements[index] = element;
        index++;
    }

    public void display() {
        for (int i = 0; i < index; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    public void shellSort() {
        // ��������h = 3 * h + 1 = 4�����һ���������0��4��8���в�������
        // ��һ������
        // ԭʼ���У�7 10 1 9 2 5 8 6 4 3
        //           0  1 2 3 4 5 6 7 8 9
        // �ź����У�2 10 1 9 4 5 8 6 7 3

        // �ڶ�������
        // ����̶����������������ƶ�һλ�������򣬼��ڶ����������1��5��9���в�������
        // ԭʼ���У�2 10 1 9 4 5 8 6 7 3
        //           0 1  2 3 4 5 6 7 8 9
        // �ź����У�2 3  1 9 4 5 8 6 7 10

        // ����������
        // ����̶����������������ƶ�һλ�������򣬼��ڶ����������2��6���в�������
        // ԭʼ���У�2 3  1 9 4 5 8 6 7 10
        //           0 1  2 3 4 5 6 7 8 9
        // �ź����У�2 3  1 9 4 5 8 6 7 10

        // ���Ĵ�����
        // ����̶����������������ƶ�һλ�������򣬼��ڶ����������3��7���в�������
        // ԭʼ���У�2 3  1 9 4 5 8 6 7 10
        //           0 1  2 3 4 5 6 7 8 9
        // �ź����У�2 3  1 6 4 5 8 9 7 10
        // ���һ������Ϊ4������

        // ��������h = (h - 1) / 3 = 1
        // ��������...

        int in, out;

        int h = 1; // ��ʼ���м��
        while (h <= index / 3) {
            h = 3 * h + 1; // ����������м��
        }

        while (h > 0) {
            for (out = h; out < index; out++) {
                int temp = elements[out];
                in = out;

                while (in > h - 1 && elements[in - h] >= temp) {
                    elements[in] = elements[in - h];
                    in -= h;
                }
                elements[in] = temp;
            }
            h = (h - 1) / 3; // ÿ���һ�����򣬼�С���м��
        }
    }
}
