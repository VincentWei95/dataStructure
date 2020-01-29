package com.example.recursion;

public class Sum {

    public static void main(String[] args) {
        Sum main = new Sum();
        System.out.println(main.sum(new int[]{ 5, 6, 7, 8, 9, 10 }));
    }

    /**
     * 数组求和
     *
     * 公开给用户使用的函数，里面的具体递归运算由子函数实现
     */
    public int sum(int[] arr) {
        return sum(arr, 0);
    }

    // 计算arr[l...n）范围里的数字的和
    // 不要把函数想成递归函数，而是函数sum()就是处理参数int[] arr和int l两个参数的普通函数
    private int sum(int[] arr, int l) {
        if (l == arr.length) return 0; // 求解最基本问题

        // 把sum(arr, l + 1)看成是一个普通函数，它处理了arr[l+1...n)的求和返回
        return arr[l] + sum(arr, l + 1); // 把原问题转化为更小的问题
    }
}
