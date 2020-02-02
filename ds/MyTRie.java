package ds;

import java.util.HashMap;
import java.util.Map;

public class MyTRie {
	TrieNode root;
	private class TrieNode{
		Map<Character, TrieNode> children;
		boolean isComplete;
		
		public TrieNode() {
			this.children = new HashMap<Character, TrieNode>();
			this.isComplete = false;
		}
		public TrieNode(boolean isComplete) {
			this.children = new HashMap<Character, TrieNode>();
			this.isComplete = isComplete;
		}
		
		
		public void insert(String s) {
			
		}
		
		private TrieNode insert(TrieNode root, String s) {
			if (s.equals("")) {
				return new TrieNode(true); 
			}
			return null;
		}
		
	}
}
