/**
 * This is a binary search tree 
 */
import java.util.function.Consumer;
public class Tree {
	protected Node root;
	Tree() {
		this.root = null;
	}
	public Node getRoot(){
		return this.root;
	}
	

	public boolean add(int value) {
		Node newNode = new Node(value);
		if (root == null) {
			root = newNode;
			return true;
		} else {
			Node parent = root;
			while (true) {
				if (newNode.value < parent.value) {
					if (parent.left == null) {
						parent.left = newNode;
						return true;
					} else {
						parent = parent.left;
					}
				} else {
					if (parent.right == null) {
						parent.right = newNode;
						return true;
					} else {	
						parent = parent.right;
					}
				}
			}
		}
	}
	
	public void inorderTraverse(Node node) {
		if (node == null) {
			return;
		}
		Node parent = node;
		inorderTraverse(parent.left);
		work(parent);
		inorderTraverse(parent.right);
	}
	public void preorderTraverse(Node node) {
		if (node == null) {
			return;
		}
		Node parent = node;
		work(parent);
		preorderTraverse(parent.left);
		preorderTraverse(parent.right);
	}
	public void postorderTraverse(Node node) {
		if (node == null) {
			return;
		}
		Node parent = node;
		postorderTraverse(parent.left);
		postorderTraverse(parent.right);
		work(parent);
	}

	public void work(Node node){
		System.out.println(node.toString());
	}
	


	


}
