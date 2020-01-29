package com.example.recursion;

public class Sum {

    public static void main(String[] args) {
        Sum main = new Sum();
        System.out.println(main.sum(new int[]{ 5, 6, 7, 8, 9, 10 }));
    }

    /**
     * �������
     *
     * �������û�ʹ�õĺ���������ľ���ݹ��������Ӻ���ʵ��
     */
    public int sum(int[] arr) {
        return sum(arr, 0);
    }

    // ����arr[l...n����Χ������ֵĺ�
    // ��Ҫ�Ѻ�����ɵݹ麯�������Ǻ���sum()���Ǵ������int[] arr��int l������������ͨ����
    private int sum(int[] arr, int l) {
        if (l == arr.length) return 0; // ������������

        // ��sum(arr, l + 1)������һ����ͨ��������������arr[l+1...n)����ͷ���
        return arr[l] + sum(arr, l + 1); // ��ԭ����ת��Ϊ��С������
    }
}
