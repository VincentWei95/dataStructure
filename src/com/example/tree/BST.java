package com.example.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
    private Node root;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // ���������������µ�Ԫ��e
    public void add(E e) {
        root = add(root, e);
    }

    // ����nodeΪ���Ķ����������в���Ԫ��e���ݹ��㷨
    // ���ز����½ڵ������������ĸ�
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        // ������ڵ�С�ڵ�ǰ�ڵ㣬������ڵ�
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }
        // ������ڵ���ڵ�ǰ�ڵ㣬�����ҽڵ�
        else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    // ���������������Ƿ����Ԫ��e
    public boolean contains(E e) {
        return contains(root, e);
    }

    // ����nodeΪ���Ķ������������Ƿ����Ԫ��e���ݹ��㷨
    private boolean contains(Node node, E e) {
        if (node == null) return false;

        // ���ҽڵ�͵�ǰ�ڵ���ͬ�����ҵ�
        if (e.compareTo(node.e) == 0) {
            return true;
        }
        // ���ҽڵ�С�ڵ�ǰ�ڵ㣬��������������ѯ
        else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        }
        // ���ҽڵ���ڵ�ǰ�ڵ㣬��������������ѯ
        else { // e.compareTo(node.e) > 0
            return contains(node.right, e);
        }
    }

    /**
     * ǰ���������õı�����ʽ
     *
     * ���裺
     * �ȷ��ʸ��ڵ㣬Ȼ���������������������������
     * �ڷ�������������ʱ��ͬ�����ȷ��������ĸ��ڵ㣬�ٷ����������ڵ���������������������ϵݹ�
     *
     * ��ÿ���ڵ㶼�ᱻ�������Σ�ǰ������������״η��ʵ�ʱ��������
     * 5->  3->  2->  3->4->  3->5->6->  8->  6->5
     * ��   ��   ��      ��         ��   ��
     *        5
     *      |  \
     *     3   6
     *    | \   \
     *    2 4   8
     *
     * ��ӡ�����5 3 2 4 6 8
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // �ǵݹ�ʵ��ǰ�к�������Ƚϸ��ӣ�Ӧ�ò���
    // ǰ�����
//    public void preOrderNR() {
//        Stack<Node> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            // ��ǰҪ���ʵ����ڵ�
//            Node cur = stack.pop();
//            // ���η��ʽڵ����������������
//            // ��ջ��Ҫ�ȷ���������������������Ҫ��ѹ����������ѹ��������
//            if (cur.right != null) {
//                stack.push(cur.right);
//            }
//            if (cur.left != null) {
//                stack.push(cur.left);
//            }
//        }
//    }

    /**
     * �����������ӡ�Ľ������˳���
     *
     * ���裺
     * �ȷ�����������Ȼ����ʸ��ڵ㣬��������������
     * �ڷ�������������ʱ��ͬ�����ȷ�����������ߣ��ٷ��������ĸ��ڵ㣬����ٷ����������ұߣ����ϵݹ�
     *
     * ��ÿ���ڵ㶼�ᱻ�������Σ�������������ڵڶ��η��ʵ�ʱ��������
     * 5->3->2->  3->  4->  3->5->  6->  8->  6->5
     *       ��   ��   ��      ��   ��   ��
     *
     *        5
     *      |  \
     *     3   6
     *    | \   \
     *    2 4   8
     *
     * ��ӡ�����2 3 4 5 6 8
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * �������
     *
     * ���裺
     * �ȷ�����������Ȼ������������������ʸ��ڵ㡣ͬ�����ϵݹ�
     *
     * ��ÿ���ڵ㶼�ᱻ�������Σ�������������ڵ����η��ʵ�ʱ��������
     * 5->3->2->  3->4->  3->  5->6->8->  6->  5
     *       ��      ��   ��         ��   ��   ��
     *
     *        5
     *      |  \
     *     3   6
     *    | \   \
     *    2 4   8
     *
     * ��ӡ�����2 4 3 8 6 5
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // �����������������
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);

            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }

    // Ѱ�Ҷ�������������СԪ��
    public E minimum() {
        if (size == 0) throw new IllegalArgumentException();

        return minimum(root).e;
    }

    // ������nodeΪ���Ķ�������������Сֵ���ڵĽڵ�
    private Node minimum(Node node) {
        if (node.left == null) return node;

        return minimum(node.left);
    }

    // Ѱ�Ҷ��������������Ԫ��
    public E maximum() {
        if (size == 0) throw new IllegalArgumentException();

        return maximum(root).e;
    }

    // ������nodeΪ���Ķ��������������ֵ���ڵĽڵ�
    private Node maximum(Node node) {
        if (node.right == null) return node;

        return maximum(node.right);
    }

    // �Ӷ�����������ɾ����Сֵ���ڽڵ�, ������Сֵ
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    // ɾ������nodeΪ���Ķ����������е���С�ڵ�
    // ����ɾ���ڵ���µĶ����������ĸ�
    private Node removeMin(Node node) {
        // �ҵ���С�Ľڵ㣬ͬʱɾ���ýڵ���ҽڵ�
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // �Ӷ�����������ɾ�����ֵ���ڽڵ�
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    // ɾ������nodeΪ���Ķ����������е����ڵ�
    // ����ɾ���ڵ���µĶ����������ĸ�
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) return null;

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }
        else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }
        else {
            // ��ɾ���ڵ�������Ϊ��
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // ��ɾ���ڵ�������Ϊ��
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // ��ɾ���ڵ����ҽڵ㶼��Ϊ�գ�Ѱ�Һ�̽ڵ����ɾ���Ľڵ�
            // ���ҵ���ɾ���ڵ���ҽڵ㣬Ȼ��Ӹ��ҽڵ��ҵ���С����ڵ㼴Ϊ��̽ڵ�
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }

    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
        }
    }
}
