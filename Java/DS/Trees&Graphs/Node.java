public class Node {
		int value;
		Node left;
		Node right;
		Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
		public String toString() {
			return "This node has value of " + this.value;
		}

		public Node getLeft(){
			return this.left;
		}

		public Node getRight(){
			return this.right;
		}
	}