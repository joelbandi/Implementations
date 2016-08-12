public class Checkbalanced{
    public static void main(String... args){

        Tree tree = new Tree();
        tree.add(12);
		tree.add(5);
		tree.add(15);
		tree.add(1);
        tree.add(4);

        System.out.println(solution(tree));







    }


    public static int height(Node node){

        if(node == null){
            return -1;
        }

        int Lheight = height(node.left);
        int Rheight = height(node.right);
        if(Lheight == Integer.MIN_VALUE || Rheight == Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        int diff = Lheight - Rheight;
        if(Math.abs(diff) > 1){
            return Integer.MIN_VALUE;
        }else{
            return Math.max(Lheight,Rheight)+1;
        }

    }


    public static boolean solution(Tree tree){
        if(height(tree.getRoot()) == Integer.MIN_VALUE){
            return false;
        }
        return true;
    }
}