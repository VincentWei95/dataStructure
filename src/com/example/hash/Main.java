package com.example.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter size of hash table: ");
        int size = getInt();
        System.out.println("Enter initial number of items: ");
        int n = getInt();

        Hash hash = new Hash(size);
        for (int i = 0; i < n; i++) {
            int key = (int) (Math.random() * 100 * size);
            hash.insert(new Hash.Link(key));
        }

        while (true) {
            System.out.println("Enter first letter of ");
            System.out.println("show, insert, delete, or find: ");
            char choice = getChar();
            switch (choice) {
                case 's':
                    hash.displayTable();
                    break;
                case 'i':
                    System.out.println("Enter key value to insert: ");
                    hash.insert(new Hash.Link(getInt()));
                    break;
                case 'd':
                    System.out.println("Enter key value to delete: ");
                    hash.delete(getInt());
                    break;
                case 'f':
                    System.out.println("Enter key value to find: ");
                    int key = getInt();
                    Hash.Link link = hash.find(key);
                    if (link != null) {
                        System.out.println("Found " + key);
                    } else {
                        System.out.println("Could not find " + key);
                    }
                    break;
                default:
                    System.out.println("invalid input");
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
