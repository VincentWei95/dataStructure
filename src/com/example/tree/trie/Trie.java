package com.example.tree.trie;

import java.util.TreeMap;

/**
 * 前缀树，一种多叉树，将每个字符作为树的节点表示，相比二叉搜索树在查询方面会有更大的优势
 */
public class Trie {

    private class Node {
        // 判断到当前节点位置是否能组合为一个单词
        public boolean isWord;
        // 一个字符可能对应多个其他树分支
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    // 获得Trie中存储的单词数量
    public int getSize() {
        return size;
    }

    // 向Trie中添加一个新的单词word
    public void add(String word) {

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 如果没有这个字符，添加
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            // 否则继续访问下一个在前缀树的字符
            cur = cur.next.get(c);
        }

        if (!cur.isWord) {
            cur.isWord = true; // word添加结束，cur指向word最后一个字符，到这个位置是一个单词
            size++;
        }
    }

    // 查询单词word是否在Trie中
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord; // 是一个单词才返回true
    }

    // 查询是否在Trie中有单词以prefix为前缀
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }

        return true;
    }
}
