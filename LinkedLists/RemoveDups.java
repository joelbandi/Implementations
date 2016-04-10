import java.util.HashSet;
public class RemoveDups{
	
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
			Node node = new Node(5);
			Node node1 = new Node();
			node.append(1);
			node.append(2);
			node.append(2);
			node.append(3);
			node.printer();
			solution(node);

	}

	public static void solution(Node node){
		
		Node node2 = new Node();
		HashSet<Integer> hs = new HashSet<Integer>();
		while(node.next!=null){

			if(!hs.contains(node.data)){
				System.out.println(node.data);
				node2.append(node.data);
			}
			node=node.next;	
		}

		if(!hs.contains(node.data)){
			node2.append(node.data);
		}


		System.out.println(hs.toString());
		node2.head=node2.next;
		node2.printer();
		//return node2;
	}
}