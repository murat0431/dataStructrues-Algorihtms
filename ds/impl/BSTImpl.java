package ds.impl;

import ds.inter.BST;

import java.util.LinkedList;
import java.util.Queue;

public class BSTImpl implements BST {
    Node root;
    int size;
    public class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void add(int number) {
        root = add(root, number);
        size++;
    }

    private Node add(Node root, int number) {
        if(root == null) {
            return new Node(number);
        } else if(number < root.value){
            root.left = add(root.left, number);
        } else {
            root.right = add(root.right, number);
        }
        return root;
    }

    @Override
    public void remove(int number) {
        root = remove(number, root);
    }

    private Node remove(int n, Node root) {
        if (root == null) return null;
        if (n < root.value) root.left = remove(n, root.left);
        if (n > root.value) root.right = remove(n, root.right);
        if (n == root.value) {
            if(root.left == null && root.right == null) {
                root = null;
            } else if(root.left == null) {
                root = root.right;
            } else if(root.right == null) {
                root = root.left;
            } else {
                int min = findMin(root.right);
                root.value = min;
                remove(min, root.right);
            }

        }
        return root;
    }

    private int findMin(Node root) {
        while (root.left != null) root = root.left;
        return root.value;
    }

    @Override
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if(root == null) return;
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    @Override
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }

    @Override
    public void levelOrder() {
        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.value + " ");
            if(curr.left != null) q.offer(curr.left);
            if(curr.right != null) q.offer(curr.right);
        }

    }

    public void traverse() {
        inOrder();
        System.out.println();
        preOrder();
        System.out.println();
        postOrder();
        System.out.println();
        levelOrder();
        System.out.println();
        System.out.println("----------------------");
    }

    public void init() {
        add(8);
        add(2);
        add(1);
        add(7);
        add(3);
        add(5);
        add(4);
        add(20);
        add(12);
        add(10);
        add(24);
        add(22);
        add(25);
    }
}
