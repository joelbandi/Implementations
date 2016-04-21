import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;


public class Graph{
	
	protected HashMap<String,ArrayList<String>> adj;
	
	Graph(){
		adj = new HashMap<String,ArrayList<String>>();
	}

	public boolean addEdge(String a,String b){
		
		if(a.equals(b)){
			return false;
		}
		if(adj.containsKey(a)){
			adj.get(a).add(b);
			return true;
		}else{
			adj.put(a,new ArrayList<String>(Arrays.asList(b)));
			return true;
		}
	}

	public Iterator iterator(){
		Set set =adj.entrySet();
		return set.iterator();
	}

	public void print(){
		System.out.println("size is "+ adj.size());
	}
}