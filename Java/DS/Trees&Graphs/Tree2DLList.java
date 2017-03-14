public class Tree2DLList{

    public static class Node{
        Node left,right;
        int value;

        Node(int value){
            this.value = value;
        }
    }

    public static class Tree{
        Node root;

        public Node convert(){

            if(this.root == null){
                return null;
            }

            Node node = convertutil(this.root);

            while(node.left!= null){
                node = node.left;
            }

            return node;
        }

        public Node convertutil(Node root){


            if(root == null){
                return root;
            }


            if(root.left != null){


                Node left = convertutil(root.left);

                while(left.right!= null){
                    left = left.right;
                }

                root.left = left;
                left.right = root;

            }

            if(root.right != null){


                Node right = convertutil(root.right);

                while(right.left!= null){
                    right = right.left;
                }

                root.right = right;
                right.left = root;
            }             

            return root;
        }

    }


    public static void main(String...a){
        Tree tree = new Tree();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        Node n = tree.convert();

        while(n!= null){
            System.out.println(n.value);
            n=n.right;
        }

    }


}