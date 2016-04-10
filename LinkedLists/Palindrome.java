import java.util.Stack;
import java.lang.*;
public class Palindrome{
		
	public static class Node{
		private int data;
		private Node next;
		public Node head;
		

		Node(int data){
			this.data=data;
			this.next=null;
			this.head = this;
		}
		

		Node(){
			this.next=null;
			this.head=this;
		}



		public void append(int data){
			Node n = head;
			while(n.next!=null){
				n=n.next;
			}
			n.next = new Node(data);
		}

		public void printer(){
			Node n = head;
			while(n.next!=null){
				System.out.println(n.data);
				n=n.next;
			}
			System.out.println(n.data);
			System.out.println();
			
		}


	}


	public static void main(String[] args){


		Node node = new Node(1);
		node.append(2);
		node.append(3);
		node.append(4);
		node.printer();


		node = solution(node);


		node.printer();

	}




	public static Node solution(Node n){
		Stack stack = new Stack();
		
		if(n==null){
			return new Node();
		}

		while(n.next!=null){
			stack.push(new Integer(n.data));
			n=n.next;
		}

		stack.push(new Integer(n.data));

		/********************************/



		Node node = new Node();

		while(!stack.empty()){
			node.append((stack.pop()).intValue());
		}

		//hotfix this!!!

		node=node.next;

		return node;


	}
}