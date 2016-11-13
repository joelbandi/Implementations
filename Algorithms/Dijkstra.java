import java.util.*;
public class Dijsktra(){

    Set<Node> frontier = new HashSet<Node>();
    // lets say the source node and destination is given to us
    HashMap<Node,Integer> distance = new HashMap<Node,Integer>();
    HashMap<Node,Node> pre = new HashMap<Node,Node>(); 
    Node source;
    Node destination;
    private final int INFINITY = Integer.MAX_VALUE;

    public static void main(){
        Node next = visit(source);
        while(next != null){
            next = visit(next)
        }


        extract_solution();

    }


    public static Node visit(Node node){

        if no more children at all{
            return null
        }

        if(the destination node is hit){
            return null;
        }

        Node next = null
        //traverses through the adjacenty matrix for node's children and for each node
        while(node are present in children){
            Node n = update(node,childnode);
            if( next!== null && distance.get(n) <= distance.get(next)){
                next = n;
            }
        }
        addtofrontier(node);
        return next;
    }

    public static Node update(Node node,Node childnode){
        if (childnode not in frontier && distance.get(childnode) >= distance.get(node) + edgeweight node -> childnode){
            distance.put(childnode,distance.get(node) + edgeweight of node -> childnode);
            pre.put(childnode,node)
        }
    }

    public static void extract_solution(){


        // got thorught the hash object called pre and retrace our steps back to the source node and put it in whatever form you like
    }

}

class Node{
    int value;
}




// given an 2-d array adjacency matrix representation of the matrix we can box each node into respective node
// and create another hash object called __distance__ containing the node as the key and the d(u) as values (init with infinity)
// create another hashobject called __pre__ containing the node values as key and the predecssor node as value 
