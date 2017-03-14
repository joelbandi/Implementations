package Lists;

public class Stack {
	private int maxsize, size;
	private int[] container;
	private int pointer;

	public Stack(int maxsize) {
		this.maxsize = maxsize;
		this.pointer = -1;
		this.size = 0;
		container = new int[maxsize];
	}

	public void push(int x) {
		if (!this.isFull()) {
			pointer++;
			container[pointer] = x;
			size++;
		}
	}

	public int pop() {
		if (!this.isEmpty()) {
			int result = container[pointer];
			pointer--;
			size--;
			return result;
		}
		return 0;
	}

	public int peek() {
		return container[pointer];
	}

	public boolean isEmpty() {
		return (pointer == -1);
	}

	public boolean isFull() {
		return (pointer == this.maxsize - 1);
	}
}
