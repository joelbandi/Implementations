import java.util.Stack;
public class SortaStack {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(53);
		stack.push(50);
		stack = sort(stack);
		System.out.println(stack.pop());
	}
	public static Stack<Integer> sort(Stack<Integer> stack) {
		Stack<Integer> helper = new Stack<Integer>();
		int count;
		while (!stack.empty()) {
			Integer temp = stack.pop();
			count = 0;
			if (!helper.empty()) {
				while (!helper.empty()) {
					if (helper.peek().compareTo(temp) > 0) {
						stack.push(helper.pop());
						count++;
					} else {
						helper.push(temp);
						for (int i = 1; i <= count; i++) {
							helper.push(stack.pop());
						}
					}
				}
			} else {
				helper.push(stack.pop());
			}
		}
		return helper;
	}
}