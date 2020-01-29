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

    // 向二分搜索树添加新的元素e
    public void add(E e) {
        root = add(root, e);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        // 待插入节点小于当前节点，插入左节点
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }
        // 待插入节点大于当前节点，插入右节点
        else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    // 看二分搜索树中是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    // 看以node为根的二分搜索树中是否包含元素e，递归算法
    private boolean contains(Node node, E e) {
        if (node == null) return false;

        // 查找节点和当前节点相同，则找到
        if (e.compareTo(node.e) == 0) {
            return true;
        }
        // 查找节点小于当前节点，往左子树继续查询
        else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        }
        // 查找节点大于当前节点，往右子树继续查询
        else { // e.compareTo(node.e) > 0
            return contains(node.right, e);
        }
    }

    /**
     * 前序遍历，最常用的遍历方式
     *
     * 步骤：
     * 先访问根节点，然后访问左子树，最后访问右子树。
     * 在访问左、右子树的时候，同样，先访问子树的根节点，再访问子树根节点的左子树和右子树，不断递归
     *
     * （每个节点都会被访问三次，前序遍历就是在首次访问的时候做处理）
     * 5->  3->  2->  3->4->  3->5->6->  8->  6->5
     * ①   ①   ①      ①         ①   ①
     *        5
     *      |  \
     *     3   6
     *    | \   \
     *    2 4   8
     *
     * 打印结果：5 3 2 4 6 8
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

    // 非递归实现前中后序遍历比较复杂，应用不广
    // 前序遍历
//    public void preOrderNR() {
//        Stack<Node> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            // 当前要访问的树节点
//            Node cur = stack.pop();
//            // 依次访问节点的左子树和右子树
//            // 在栈中要先访问左子树和右子树，需要先压入右子树后压入左子树
//            if (cur.right != null) {
//                stack.push(cur.right);
//            }
//            if (cur.left != null) {
//                stack.push(cur.left);
//            }
//        }
//    }

    /**
     * 中序遍历，打印的结果会是顺序的
     *
     * 步骤：
     * 先访问左子树，然后访问根节点，最后访问右子树。
     * 在访问左、右子树的时候，同样，先访问子树的左边，再访问子树的根节点，最后再访问子树的右边，不断递归
     *
     * （每个节点都会被访问三次，中序遍历就是在第二次访问的时候做处理）
     * 5->3->2->  3->  4->  3->5->  6->  8->  6->5
     *       ②   ②   ②      ②   ②   ②
     *
     *        5
     *      |  \
     *     3   6
     *    | \   \
     *    2 4   8
     *
     * 打印结果：2 3 4 5 6 8
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
     * 后序遍历
     *
     * 步骤：
     * 先访问左子树，然后访问右子树，最后访问根节点。同样不断递归
     *
     * （每个节点都会被访问三次，后序遍历就是在第三次访问的时候做处理）
     * 5->3->2->  3->4->  3->  5->6->8->  6->  5
     *       ③      ③   ③         ③   ③   ③
     *
     *        5
     *      |  \
     *     3   6
     *    | \   \
     *    2 4   8
     *
     * 打印结果：2 4 3 8 6 5
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

    // 二分搜索树层序遍历
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

    // 寻找二分搜索树的最小元素
    public E minimum() {
        if (size == 0) throw new IllegalArgumentException();

        return minimum(root).e;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node) {
        if (node.left == null) return node;

        return minimum(node.left);
    }

    // 寻找二分搜索树的最大元素
    public E maximum() {
        if (size == 0) throw new IllegalArgumentException();

        return maximum(root).e;
    }

    // 返回以node为根的二分搜索树的最大值所在的节点
    private Node maximum(Node node) {
        if (node.right == null) return node;

        return maximum(node.right);
    }

    // 从二分搜索树中删除最小值所在节点, 返回最小值
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        // 找到最小的节点，同时删除该节点的右节点
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除最大值所在节点
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
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
            // 待删除节点左子树为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 待删除节点右子树为空
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 待删除节点左右节点都不为空，寻找后继节点替代删除的节点
            // 先找到待删除节点的右节点，然后从该右节点找到最小的左节点即为后继节点
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
