package com.example.tree.bst.collection.set;

import com.example.tree.bst.BST;

/**
 * 基于二分搜索树实现的Set，时间复杂度为O(logN)，在java中可以使用TreeSet实现（TreeSet是基于TreeMap使用红黑树（平衡树）实现，不会出现O(n)时间复杂度）
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet(){
        bst = new BST<>();
    }

    @Override
    public int getSize(){
        return bst.size();
    }

    @Override
    public boolean isEmpty(){
        return bst.isEmpty();
    }

    @Override
    public void add(E e){
        bst.add(e);
    }

    @Override
    public boolean contains(E e){
        return bst.contains(e);
    }

    @Override
    public void remove(E e){
        bst.remove(e);
    }
}
