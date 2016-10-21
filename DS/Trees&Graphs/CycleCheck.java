/*

There are many ways to 
    Find existence of a cycle in Graph,
    Find out whether its a DAG,
1. Using normal dfs to find any existence of backedges using an a) extra data strucure or b) even colors technique
2. Using BFS to find if a node is revisited
    Find out a valid order of elements that may/may not block each other due to their temporal relationships
3. Trying to topologically sort the graph

*/

public class CycleCheck {


    public static void main(String[] args) {
        
    }

    public boolean one_a(Grph g,Integer root){

        HashSet<Integer> cache;
        for(Integer i : g.getNeighbours(root)){

            cache = new HashSet<Integer>();
            if(!one_a_util(g,root,cache)){
                
            }

        }

    }

}