package ds.test;

import ds.impl.BSTImpl;
import ds.inter.BST;

public class BSTTest {
    public static void main(String[] args) {
        BST tree = new BSTImpl();
        tree.init();
        tree.traverse();
        //tree.remove(4);
        //tree.traverse();
        //tree.remove(2);



    }
}
