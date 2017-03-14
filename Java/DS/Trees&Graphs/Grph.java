import java.util.*;
import java.util.function.Consumer;


public class Grph<E>{

    private HashMap<E,ArrayList<E>> map;

    Grph(){
        map = new HashMap<E,ArrayList<E>>();
    }

    public boolean addEdge(E a,E b){

        if(a == null || b == null){
            return false;
        }

        if(a.equals(b)){
			return false;
		}

		if(map.containsKey(a)){
			map.get(a).add(b);
            if(!map.containsKey(b)){
                map.put(b,new ArrayList<E>());
            }
			return true;
		}else{
			map.put(a,new ArrayList<E>(Arrays.asList(b)));
            if(!map.containsKey(b)){
                map.put(b,new ArrayList<E>());
            }
			return true;
		}

    }


    public int size(){
		return map.size();
	}

    public Iterator iterator(){
		Set set =map.entrySet();
		return set.iterator();
	}

    public void print(){
		Iterator i = iterator();

		while(i.hasNext()){
			Map.Entry e = (Map.Entry)i.next();
			for(E item : map.get(e.getKey())){

				System.out.print(e.getKey() + " -> ");
				System.out.print(item);
				System.out.println();

			}
		}
	}

    public ArrayList<E> getNeighbours(E item){
		return map.containsKey(item)? map.get(item) : null;
	}


	// public void DFS(E root,Consumer<E> consumer){
	// 	HashSet<E> visited = new HashSet<E>();
	// 	DFS_worker(root,consumer,visited);
	// }

    // public void DFS_worker(E root,Consumer<E> consumer,HashSet<E> visited){
		
	// 	// DFS with a recursive implementation
    //     //AWESOME!!
		
	// 	if(visited.contains(root)){
	// 		return;
	// 	}



	// 	if(!map.containsKey(root)){
	// 		return;
	// 	}

	// 	for(E item : getNeighbours(root)){
	// 		DFS_worker(item,consumer,visited);
	// 	}

	// 	consumer.accept(root);
	// 	visited.add(root);

	// }


}