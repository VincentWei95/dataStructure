package com.example.tree;

import java.util.Random;

public class Main {

    // ��������˳��
    private static void shuffle(Object[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = (int) (Math.random() * (i + 1));
            Object t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int n = 10000;

        for (int i = 0; i < n; i++)
            bst.add(random.nextInt(n));

        // ע��, ����������ɵ��������ظ�, ����bst�е����������������С��n��

        // order�����д��[0...n)������Ԫ��
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++)
            order[i] = i;
        // ����order�����˳��
        shuffle(order);

        // ����ɾ��[0...n)��Χ�������Ԫ��
        for (int i = 0; i < n; i++)
            if (bst.contains(order[i])) {
                bst.remove(order[i]);
                System.out.println("After remove " + order[i] + ", size = " + bst.size());
            }

        // ������������������Ӧ��Ϊ��
        System.out.println(bst.size());
    }
}
