import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
public class Graph{
	protected HashMap<Node,ArrayList<Node>> adj;
	protected class Node{
		int value;
		Node(int value){
			this.value=value;
		}
		int printString(){
			return value;
		}
	}
	Graph(){
		adj = new HashMap<Node,ArrayList<Node>>();
	}
	public boolean addEdge(int one,int two){
		if(one==two){
			return false;
		}
		Node a = new Node(one);
		Node b = new Node(two);
		if(adj.containsKey(a)){
			adj.get(a).add(b);
			return true;
		}else{
			adj.put(a,new ArrayList<Node>());
			return true;
		}
	}
	public Iterator giveIterator(){
		Set set = adj.entrySet();
		Iterator iterator = set.iterator();
		return iterator;
	}
	public void printNumEdges(){
		System.out.println("Printing all edges");
		System.out.println(adj.size());
		// Iterator i = giveIterator();
		// while(i.hasNext()){
		// 	Map.Entry entry = (Map.Entry)i.next();
		// 	for(Node node: (ArrayList<Node>)entry.getValue()){
		// 		System.out.print(((Node)entry.getKey()).printString()+" -> ");
		// 		System.out.print(node.printString());
		// 		System.out.println();
		// 	}
		// }
	}
}