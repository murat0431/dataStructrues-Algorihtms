package ds;

public class MyBinarySearchTree {
	Node root;
	public MyBinarySearchTree(Node root) {
		// TODO Auto-generated constructor stub
		this.root = root;
	}
	public MyBinarySearchTree() {
		
	}

	class Node {
		int value;
		Node left;
		Node right;
		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
		public Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	public void add(int value) {
		root = add(root, value);
		
	}
	
	private Node add(Node root, int value) {
		if(root == null) {
			return new Node(value);
		} else if(value < root.value) {
			root.left = add(root.left, value);
		} else{
			root.right = add(root.right, value);
		}
		return root;
	}
	
	public void print() {
		print(root);
	}
	/**
	 * In order BST traversal
	 * @param root
	 */
	private void print(Node root) {
		if(root != null) {	
			print(root.left);
			System.out.println(root.value);
			print(root.right);
		}
	}
}
