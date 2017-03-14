public class Stack {
	private class Node {
		protected int data;
		public Node prev;
		public Node(int data) {
			this.data = data;
			this.prev = null;
			count++;
		}
	}
	private int count;
	private Node min;
	private Node top;
	Stack() {
		this.min = null;
		this.top = null;
		count = 0;
	}
	public void push(int data) {
		Node newnode = new Node(data);
		newnode.prev = top;
		top = newnode;
		if (min.data >= data) {
			min = newnode;
		}
		count++;
	}
	public int getMin() {
		return min.data;
	}
	public int pop() {
		if (count > 0) {
			Node newnode = top;
			top = top.prev;
			count--;
			return newnode.data;
		}

		return 0;
	}
}