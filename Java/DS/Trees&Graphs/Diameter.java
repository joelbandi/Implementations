public class Diameter {
    public static void main(String[] args) {

        Node root;
        PQ pq;

        maxHeight(root,pq);
        the element in PQ +1;
        
    }


    public static int maxHeight(Node n,PQ pq){

        if(n.left == null && n.right == null){
            // put the node & (abs(1)) in a priority queue
            return 1;
        }

        if(n.left == null){
            int right = maxHeight(n.right,pq);
            // put the node & (abs(left)) in a priority queue
            return 1+right; 
        }

        if(n.right == null){
            int left = maxHeight(n.left,pq);
            // put the node & (abs(left)) in a priority queue
            return 1+left;
        }

        int left = maxHeight(n.left,pq);
        int right = maxHeight(n.right,pq);

        // put the node & (abs(left+right)) in a priority queue
        return 1+Math.max(left,right);
    }
}