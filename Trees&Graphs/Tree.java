public class Tree {
	public Node root;
	Tree() {
		this.root = null;
	}
	public boolean add(int value) {
		Node newNode = new Node(value);
		if (root==null){
		root = newNode;
		return true;
		}else{
			Node parent = root;
			while(true){
				if (newNode.value < parent.value) {
					if(parent.left==null){
						parent.left = newNode;
						return true;
					}else{
						parent=parent.left;
					}
				}else{
					if(parent.right==null){
						parent.right = newNode;
						return true;
					}else{
						parent=parent.right;
					}
				}
			}
		}
	}

	public boolean remove(int value){
		
	}

	public void inorderTraverse(Node node){
		
		if(node==null){
			return;
		}

		Node parent = node;
		inorderTraverse(parent.left);
		work(parent);
		inorderTraverse(parent.right);
	}

	public void preorderTraverse(Node node){
		
		if(node==null){
			return;
		}

		Node parent = node;
		work(parent);
		preorderTraverse(parent.left);
		preorderTraverse(parent.right);
	}

	public void postorderTraverse(Node node){
		
		if(node==null){
			return;
		}

		Node parent = node;
		postorderTraverse(parent.left);
		postorderTraverse(parent.right);
		work(parent);
	}

	public void work(Node node){
		System.out.println(node.value);
	}



}
class Node {
	int value;
	Node left;
	Node right;
	Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	public String toString() {
		return "This node has value of " + value;
	}
}