package ds.test;

import ds.impl.BSTImpl;
import ds.inter.BST;

public class BSTTest {
    public static void main(String[] args) {
        BST tree = new BSTImpl();
        tree.add(7);
        tree.add(6);
        tree.add(2);
        tree.add(5);
        tree.add(4);
        tree.add(10);
        tree.add(9);
        tree.add(8);
        tree.add(12);
        tree.add(11);
        tree.add(16);
        tree.add(20);

        tree.inOrder();
        System.out.println();
        tree.preOrder();
        System.out.println();
        tree.postOrder();
    }
}
