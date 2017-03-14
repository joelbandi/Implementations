public class Successor {
    public static void main(String[] args) {
        
    }


    public static Node solution(Node node){


        if(node.right != null){
            node = node.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }else{
            if(node.parent != null && node.parent.left == node){
                return node.parent;
            }
            else{
                while(node.parent!= null && node.parent.left != node){
                    node = node.parent;
                }
                return node;
            }
        }

        
        return null;

    }


    public static class Node{
        int value;
        Node left,right,parent;
    }
}