
/**
 * LCA OF BINARY TREE ASSUMING THERE ARE LINKS TO PARENTS AS WELL:
 * 
 * METHOD1 -> same case as that of finding an intersection of the two nodes on a linked list.
 * 1. Start at two nodes and traverse upwards and find difference if length.
 * 2. Travel the longer of the two paths by difference and from then start travelling upwards.
 * 3. the first common node is your LCA.
 * 
 * 
 * 
 * 
 * LCA OF BINARY TREE ASSUMING THERE ARE NO LINKS TO PARENTS :
 * 
 * METHOD2.1 -> O(N) RUNTIME BUT THREE TRAVERSALS AND USES A EXTRA SPACE FOR ARRAYS
 * //recursive
 * 1.Traverse through tree and find a path to node1 and stick elevery element in the path in an array
 * 2.Do the same for node2 and stick in an another array
 * 3.Compare two arrays from beginning and find the last common element in each array
 * 4.The last common element in the array is the LCA
 * 
 * METHOD2.2 -> O(N) RUNTIME BUT ONE TRAVERSAL AND USES NO EXTRA SPACE (assumes both nodes are present in the tree)
 * //recursive
 * 1. Traverse from the root of the tree at the root, if root node value is equals to any of the two nodes, 
 *    then return that node. If the root node turns out to be a null then return null
 * 2. If root node isnt equal to neither of them then, recurse for both left and right node and store the returned nodes
 * 3. If both nodes are not null then return the current iterations root node as ans
 * 4. If only one of them is null then return the non null node as the ans
 * 5. . Also this assumes that both nodes are present in node
 * 6. to overcome above problem just use a couple of booleans in the global namespace to indicate present nodes 
 * 
 * 
 * 
 * LCA OF BINARY SEARCH TREES :
 * 
 * METHOD 3.1 -> O(h)runtime h=height of tree;  single traversal 
 * 1. Traverse from the root of the tree and the first node whose valule lies between the two argument nodes is the LCA
 * 2. Keep checking if youre going to the left or right of the range between the two argument nodesa dn traverse accordingly 
 * 3. Traverse either iterativley or recursively whatever your fancy about
 * 
 **/
import java.util.ArrayList;
 public class LCA{

     public static void main(String... arg){
         
         System.out.println("hello world!");

         if(true) ? System.out.println("two") : System.out.println("three");


     }


     public static Btree LCA1(Btree root, Btree tree1, Btree tree2){
         int n1 = (tree1.value <= tree2.value) ? tree1.value : tree2.value
         int n1 = (tree1.value <= tree2.value) ? tree2.value : tree1.value;
         int l1 = getDepth(root,tree1);
         int l2 = getDepth(root,tree2);
         if(l1 == Integer.MIN_VALUE || l2 == Integer.MIN_VALUE){
             return null;
         }
         int delta = MATH.abs(l2-l1);

         if(l1>l2){
             Btree deep = tree1;
             Btree shallow = tree2;  
         }else{
             Btree deep = tree2;
             Btree deep = tree1;
         }

         //try to snip the excess chain in the deeper node
         for(int i = 1; i<= delta ; i++ ){
             deep = deep.parent;
         }

         // we have both nodes at same depth

         while(true){
             if(deep == null || shallow == null){
                 return null;
             }

             if(deep == shallow){
                 return deep;
             }else{
                 deep = deep.parent;
                 shallow = shallow.parent;
             }
         }

     }

     private static int getDepth(Btree root, Btree tree){
         int count = 0;
         while(true){
             if(root == null){
                 return Integer.MIN_VALUE;
             }
             if(root.value == tree.value){
                 return count;
             }else if (root.value <= tree.value){
                 root = root.right;
                 count++;
             }else if (root.value >= tree.value){
                 root = root.left;
                 count++;
             }
         }
     }

     public static Btree LCA2_1(Btree root, Btree tree1 , Btree tree2){

         ArrayList<Btree> list1,list2;
         boolean v1,v2; v1=v2=false;
         if(genPath(root,tree1,list1,v1) && genPath(root,tree2,list2,v2) && v1 && v2){
            int n1 = (list1.size() <= list2.size())? list1.size() : list2.size();
            int n2 = (list1.size() <= list2.size())? list2.size() : list1.size();

            for(int i = 0 ; i < n1 ; i++){
                if(list1.get(i) != list2.get(i)){
                    return list1.get(i-1);
                }
            }

         }else{
             return null;
         }
         

     }

     private static bool genPath(Btree root, Btree target, ArrayList<Btree> al, boolean v){

        if(root == null){
            return false;
        }
        
        al.add(root);

        if(root.value == target.value){
            v = true;
            return true;
        }

        if((genPath(root.left,target,al)) ||
        (genPath(root.right,target,al))){
            return true;
        }
        al.remove(al.size()-1);
     }

     public static Btree LCA2_2(Btree root, Btree tree1, Btree tree2){
        
        if(root.value == tree1.value || root.value == tree2.value){
            return root;
        }
        if(root == null){
            return null;
        }
        Btree left = LCA2_2(root.left,tree1,tree2);
        Btree right = LCA2_2(root.right,tree1,tree2);

        if(left != null && right!= null){
            return root;
        }

        if(left == null && right == null){
            return null;
        }

        return (left == null)? right : left;

     }

     public static Btree LCA3_1(Btree root, Btree tree1, Btree tree2){
         //iterative approach
         int n1 = (tree1.value <= tree2.value) ? tree1.value : tree2.value;
         int n2 = (tree1.value <= tree2.value) ? tree2.value : tree1.value;
         while(true){
             if(root == null){
                 return null; //we dont have an LCA 
             }
             if(root.value >= n1 && root.value <= n2){
                 return root;
             }else if (root.value < n1){
                 root = root.right;
             }else if (root.value > n2){
                 root = root.left;
             }
         }
     }

 }
