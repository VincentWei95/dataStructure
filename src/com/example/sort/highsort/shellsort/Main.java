package com.example.sort.highsort.shellsort;

public class Main {

    public static void main(String[] args) {
        ShellSort sort = new ShellSort(10);
        sort.insert(10);
        sort.insert(3);
        sort.insert(5);
        sort.insert(6);
        sort.insert(7);
        sort.insert(9);
        sort.insert(8);
        sort.insert(2);
        sort.insert(1);
        sort.insert(4);

        sort.display();
        sort.shellSort();
        sort.display();
    }
}
