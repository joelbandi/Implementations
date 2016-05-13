import java.util.*;


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

	public void printsize(){
		System.out.println("size is "+ adj.size());
	}


	public void print(){
		Iterator i = iterator();
		while(i.hasNext()){
			Map.Entry e = (Map.Entry)i.next();

			for(String string : adj.get(e.getKey())){
				System.out.print(e.getKey() + " -> ");
				System.out.print(string);
				System.out.println();
			}
		}
	}


	public ArrayList<String> getNeighbours(String s){
		return adj.containsKey(s)? adj.get(s) : new ArrayList<String>();
	}

}