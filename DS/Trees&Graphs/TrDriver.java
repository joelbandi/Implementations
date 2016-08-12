public class TrDriver{
	public static void main(String[] Args){
		Tree tree = new Tree();
		tree.add(12);
		tree.add(5);
		tree.add(1);
		tree.add(15);

		System.out.println("In order Traversal");
		tree.inorderTraverse(tree.getRoot());
		System.out.println("Pre order Traversal");
		tree.preorderTraverse(tree.root);
		System.out.println("Post order Traversal");
		tree.postorderTraverse(tree.root);


		

	}
}