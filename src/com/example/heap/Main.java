package com.example.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        Heap heap = new Heap(31);
        heap.insert(70);
        heap.insert(40);
        heap.insert(50);
        heap.insert(20);
        heap.insert(60);
        heap.insert(100);
        heap.insert(80);
        heap.insert(30);
        heap.insert(10);
        heap.insert(90);

        while (true) {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, remove, change: ");
            int choice = getChar();
            switch (choice) {
                case 's':
                    heap.displayHeap();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    heap.insert(getInt());
                    break;
                case 'r':
                    heap.remove();
                    break;
                case 'c':
                    System.out.print("Enter current index of item: ");
                    int value = getInt();
                    System.out.print("Enter new key: ");
                    int value2 = getInt();
                    heap.change(value, value2);
                    break;
            }
        }
    }

    private static String getString() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static char getChar() {
        return getString().charAt(0);
    }

    public static int getInt() {
        return Integer.parseInt(getString());
    }
}
