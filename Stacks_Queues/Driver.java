public class Driver{
	public static void main(String[] Args){
		Stack s = new Stack();

		s.push(6);
		s.push(9);
		s.push(3);
		s.push(7);
		s.push(5);

		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.getMin());

	}
}