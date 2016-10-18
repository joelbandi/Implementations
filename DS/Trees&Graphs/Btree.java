import java.util.ArrayList;
import java.util.Stack;
public class Btree{
    Btree left;
    Btree right;
    Btree parent;
    int value;
    boolean isEmpty;

    Btree(int v){
        this.value=v;
        this.isEmpty=false;
        this.right=null;
        this.left=null;
        this.parent=null;
    }

    Btree(int v,Btree r,Btree l,Btree p){
        this.value=v;
        this.isEmpty=false;
        this.right=r;
        this.left=l;
        this.parent=parent;
    }

    Btree(){
        this.right=null;
        this.left=null;
        this.parent=null; 
        this.isEmpty=true;
    }

    /**
     * 
     * This Function creates a tree representation from a preorder sequence arraylist of a tree.
     * Every unique tree has its own unique pre order traversal pattern.
     * 
     **/


    public static Btree create(ArrayList<Integer> list){
        if(list == null){
            return null;
        }
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = list.size()-1 ; i >=0 ; i--){
            stack.push(list.get(i));
        }
        return preorderadd(new Btree(),stack);
        
    }

    private static Btree preorderadd(Btree btree, Stack<Integer> stack){
        if(stack.empty()){
            return null;
        }
        btree.setPayload(stack.pop());
        btree.setLeft(preorderadd(new Btree(),stack));
        btree.setRight(preorderadd(new Btree(),stack));
        return btree;
    }

    public void setPayload(int v){
        this.value=v;
        this.isEmpty=false;
    }


    /**
     *  API practice: optional tho
     *  Btree one = new Btree(3);
     *  Btree two = new Btree(5);
     *  one.setRight(two.setParent(one));
     **/

    public Btree setParent(Btree p){
        this.parent=p;
        return this;
    }

    public void setRight(Btree r){
        this.right=r;
    }

    public void setLeft(Btree l){
        this.left=l;
    }


    public void add(int v){
        if(this.isEmpty){
            this.value=v;
            return;
        }
        
            if(v<=this.value){
                if(this.left==null){
                    this.left = new Btree(v);
                    return;
                }else{
                    this.left.add(v);
                }
            }else{
                if(this.right==null){
                    this.right = new Btree(v);
                    return;
                }else{
                    this.right.add(v);
                }
            }
    }

    public void inorder(){
        if(this.left!=null){
            this.left.inorder();
        }
        System.out.println(this.value);
        if(this.right!= null){
            this.right.inorder();
        }
    }

    public void revinorder(){
        if(this.right!= null){
            this.right.inorder();
        }
        System.out.println(this.value);
        if(this.left!=null){
            this.left.inorder();
        }
    }

    public void preorder(){
        System.out.println(this.value);
        if(this.right!= null){
            this.right.preorder();
        }
        if(this.left!=null){
            this.left.preorder();
        }
    }

    public void postorder(){
        if(this.right!= null){
            this.right.postorder();
        }
        if(this.left!=null){
            this.left.postorder();
        }
        System.out.println(this.value);
    }
    

}