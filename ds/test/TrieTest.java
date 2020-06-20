package ds.test;

import ds.impl.Trie;

public class TrieTest {
    public static void main(String[] args) {
        Trie tr = new Trie();
        tr.insert("apple");
        boolean x = tr.search("apple");
        System.out.println(x);
    }
}
