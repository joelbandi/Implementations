// Grphtest.java
//BFS & DFS
import java.util.*;
public class DFSBFS{

    public static void main(String...a){
        Grph<String> g = new Grph<String>();
        HashSet<String> v = new HashSet<String>();

        g.addEdge("0","1");
        g.addEdge("0","4");
        g.addEdge("0","5");
        g.addEdge("1","4");
        g.addEdge("1","3");
        g.addEdge("3","4");
        g.addEdge("3","2");
        g.addEdge("2","1");


        BFS(g,v,"0");

    }

    public static void DFS(Grph<String> g,HashSet<String> v,String root){


        // termination
        if(root == null){
            return;
        }

        // repetition check
        if(v.contains(root)){
            System.out.println("Cycle detected");
            return;
        }else{
            v.add(root);
        }

        // visit
        System.out.println("visited : "+root);

        //Recursive calls
        for(String nei : g.getNeighbours(root)){
            DFS(g,v,nei);
        }
        
    }


    public static void BFS(Grph<String> g,HashSet<String> v,String root){

        if(root == null){
            return;
        }
        ArrayDeque<String> q = new ArrayDeque<String>();
        q.addLast(root);
        v.add(root);
        String current;
        while(q.size() != 0){
            current = q.removeFirst();
            System.out.println("Visited : "+current);
            for(String s : g.getNeighbours(current)){
                if(!v.contains(s)){
                    v.add(s);
                    q.addLast(s);
                }
        }
        }
    }

}