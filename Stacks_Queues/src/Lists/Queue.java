package Lists;

public class Queue {
	private int maxsize, size;
	private int[] container;
	private int start, end;

	public Queue(int maxsize) {
		this.maxsize = maxsize;
		container = new int[maxsize];
		size = 0;
		start = 0;
		end = -1;
	}

	protected void align() {
		int k = 0;
		for (int i = start; i < end; i++) {
			container[k] = container[i];
			k++;
			start = 0;
			end = k - 1;
		}
	}

	public void enqueue(int x) {
		if (!this.isFull()) {
			end++;
			container[end] = x;
			size++;
		}
	}

	public int dequeue() {
		if (!this.isEmpty()) {
			int result = container[start];
			start++;
			size--;
			this.align();
			return result;
		}
		return 0;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public boolean isFull() {
		return (size == maxsize);
	}

}
