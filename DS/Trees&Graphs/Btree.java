public class Btree{
    Btree left;
    Btree right;
    int value;
    boolean isEmpty;

    Btree(int v){
        this.value=v;
        this.isEmpty=false;
        this.right=null;
        this.left=null;
    }

    Btree(int v,Btree r,Btree l){
        this.value=v;
        this.right=r;
        this.left=l;
        this.isEmpty=false;
    }

    Btree(){
        this.right=null;
        this.left=null; 
        this.isEmpty=true;
    }

    public void setPayload(int v){
        this.value=v;
        this.isEmpty=false;
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
    


}