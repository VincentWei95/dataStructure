package com.example.tree.bst.collection.set;

import com.example.tree.bst.BST;

/**
 * ���ڶ���������ʵ�ֵ�Set��ʱ�临�Ӷ�ΪO(logN)����java�п���ʹ��TreeSetʵ�֣�TreeSet�ǻ���TreeMapʹ�ú������ƽ������ʵ�֣��������O(n)ʱ�临�Ӷȣ�
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
