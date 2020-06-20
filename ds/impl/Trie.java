package ds.impl;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    TrieNode root;

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;

        public TrieNode() {
            children = new HashMap<>();
        }
    }
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = this.root;
        for(char c : word.toCharArray()) {
            curr = insertChar(curr, c);
        }
        curr.isWord = true;

    }

    private TrieNode insertChar(TrieNode root, char c) {
        if(root.children.containsKey(c)) return root.children.get(c);
        TrieNode newNode = new TrieNode();
        root.children.put(c, newNode);
        return newNode;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode c = search(this.root, word, 0);
        return c == null ? false : c.isWord;
    }

    private TrieNode search(TrieNode curr, String word, int i) {
        if(i==word.length()) return curr;
        if(curr.children.containsKey(word.charAt(i))) {
            return search(curr.children.get(word.charAt(i)), word, i+1);
        }
        return null;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode c = search(this.root, prefix, 0);
        return c != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
