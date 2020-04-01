package ds.inter;

public interface BST {
    int size();
    void add(int number);
    void remove(int number);
    void preOrder();
    void inOrder();
    void postOrder();
    void levelOrder();
    void traverse();
    void init();
}
