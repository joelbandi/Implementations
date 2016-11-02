/*

There are many ways to 
    Find existence of a cycle in Graph,
    Find out whether its a DAG,
1. Using normal dfs to find any existence of backedges using an a) extra data strucure or b) even colors technique
2. Using BFS to find if a node is revisited
    Find out a valid order of elements that may/may not block each other due to their temporal relationships
3. Trying to topologically sort the graph

*/
import java.util.*;
public class CycleCheck {


    public static void main(String[] args) {

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);

        a.add(b);
        a.add(c);
        a.add(d);
        c.add(e);
        e.add(f);
        // comment next line to see difference
        f.add(c);
        b.add(f);
        d.add(f);



        // System.out.println(one_a(a));
        Stack<Node> s = new Stack<Node>();
        toposort(a,s);
        System.out.println(Arrays.toString(s.toArray()));

        


        
    }

    public static class Node{

        int value;
        ArrayList<Node> neighbours;
        String status;

        Node(int value){
            neighbours = new ArrayList<Node>();
            this.value = value;
            status = "unvisited";
        }

        Node add(Node n){
            this.neighbours.add(n);
            return this;
        }

        public String toString(){
            return Integer.toString(this.value);
        }

    }


    public static boolean one_a(Node root){

        if(root.status == "processing"){
            return true;
        }
        root.status = "processing";

        for(Node n: root.neighbours){
           if(one_a(n)){
               return true;
           }
        }

        root.status = "visited";
        return false;

    }

    public static void toposort(Node root,Stack<Node> s){

        if(root.status == "visited"){
            return;
        }



        for(Node n : root.neighbours){

            toposort(n,s);

        }

        root.status="visited";
        s.push(root);


    }

}