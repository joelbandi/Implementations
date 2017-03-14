public class ValidateBST{
    static final int PASS = Integer.MAX_VALUE;
    static final int FAIL = Integer.MIN_VALUE;

    public static void main(String...args){
        Tree tree = new Tree();
		tree.add(12);
		// tree.add(5);
		// tree.add(15);

		// tree.inorderTraverse(tree.getRoot());
        // System.out.println(tree.getRoot().right.toString());

        System.out.println(solution(tree));
        



    }


    public static int isBST(Node node){
        if(node == null){
            return PASS;
        }

        int left = isBST(node.left);
        int right = isBST(node.right);
        boolean cond = (left == PASS && right == PASS && (node.left.value <= node.value && node.value <= node.right.value));
        if(cond){
            return PASS;
        }else{
            return FAIL;
        }
    }

    public static boolean solution(Tree tree){
        if(isBST(tree.getRoot()) == FAIL){
            return true;
        }else{
            return false;
        }
    }


}