public class Node{
	 int data;
	 Node next = null;
	 Node head = this;
	 Node tail = this;
	 
	 void append(int y){
		

		Node end = new Node();
		end.data=y;
		Node n = this;
		while(n.next!=null){
			n = n.next;
		}
		n.next = end;
		tail = n;

		
	}

	void remove(int y){
		if(this.data==y){
			this.data = this.next.data;
			this.next = this.next.next;
		}
		Node n = this;

		while(n.next.next!= null){
			if(n.data==y){
				n.data = n.next.data;
				n.next = n.next.next;
			}
			n=n.next;
		}

		if(n.next.data == y){
			n.next = null;
		}
		tail=n;
	}

	 void printem(){

		Node n = this;
		n=n.next;
		System.out.print("Head->");
		while(n.next!=null){
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println(n.data );
		
	}

	boolean isEmpty(){

		if(head.equals(tail)){
			return true;
		}
		else{
			return false;
		}
	}





}