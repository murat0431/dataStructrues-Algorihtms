package ds;

import java.util.ArrayList;
import java.util.List;

public class MyHashTable {
	public final int INITIAL_SIZE = 11;
	public static final double LOAD_FACTOR_THRESHOLD = 0.75;

	private int size;
	Node[] table = new Node[INITIAL_SIZE];

	class Node {
		private int key;
		private int value;
		Node next;

		public Node(int key, int value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	private int getLoadFactor() {
		return this.size / this.table.length;
	}

	private int hash(int key) {
		return key % this.table.length;
	}

	private Node getPreviousNode(int key) {
		int index = this.hash(key);
		Node current = table[index];
		if (current == null) {
			return null;
		}

		if (current.key == key) {
			return current;
		}

		while (current.next != null && current.next.key != key) {
			current = current.next;
		}
		if (current.next != null && current.next.key == key) {
			return current;
		}

		return null;
	}

	public void remove(int key) {
		int index = this.hash(key);
		Node returnedNode = this.getPreviousNode(key);
		if (returnedNode == null) {
			System.out.println("Nothing to remove!!");
		}
		// if it is the head
		if (returnedNode.key == key) {
			table[index] = table[index].next;
		} else {
			returnedNode.next = returnedNode.next.next;
			this.size = this.size - 1;
			System.out.println("(" + returnedNode.key + ", " + returnedNode.value + ") " + "is successfully removed");
		}

	}
	
	public int get(int key) {
		Node returnedNode = this.getPreviousNode(key);
		if (returnedNode == null) {
			return -1;
		}
		if (returnedNode.key == key) {
			return returnedNode.value;
		} 
		return returnedNode.next.value;
	}
	
	public void add(int key, int value) {
		Node prevNode = this.getPreviousNode(key);
		if (prevNode != null) {
			if (prevNode.key == key) {
				prevNode.value = value;
			} else {
				prevNode.next.value = value;
			}
		} else {
			int index = this.hash(key);
			if (table[index] == null) {
				table[index] = new Node(key, value, null);
			} else {
				Node current = table[index];
				while(current.next != null) {
					current = current.next;
				}
				current.next = new Node(key, value, null);
				this.size++;
				if (getLoadFactor() > LOAD_FACTOR_THRESHOLD) {
					Node[] oldTable = this.table;
					this.table = new Node[table.length*2];
					this.size = 0;
					//TODO copy old array elements into new array by calling add function recursively
					for (int i = 0; i < oldTable.length; i++) {
						Node n = oldTable[i];
						while (n.next != null) {
							add(n.key, n.value);
						}
					}
				}
				
			}
		}
	}
	
	
	

}
