//Driver class contains a demo of the stack and queue libraries


import Lists.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lists.Queue one = new Lists.Queue(5);
		one.enqueue(5);
		one.enqueue(9);
		System.out.println(one.dequeue());
		System.out.println(one.dequeue());
		
		
		Lists.Stack two = new Lists.Stack(5);
		
		two.push(7);
		two.push(8);
		two.push(10);
		System.out.println(two.pop());
		System.out.println(two.pop());
		System.out.println(two.pop());
		
		
		
	}

}
