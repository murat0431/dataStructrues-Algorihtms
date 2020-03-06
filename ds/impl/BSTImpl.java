package ds.impl;

import ds.inter.BST;

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
}
