public class BtreeTest{
    public static void main(String ...a){
        Btree b = new Btree(5);
        b.add(3);b.add(7);
        b.add(2);b.add(4);
        b.add(6);b.add(8);
        b.inorder();
    }
    
}