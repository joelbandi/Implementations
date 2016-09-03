import java.util.ArrayList;
public class BtreeTest{
    public static void main(String ...a){
        Btree b = new Btree(5);
        b.add(3);b.add(7);
        b.add(2);b.add(4);
        b.add(6);b.add(8);
        b.inorder();
        System.out.println("-----------------");
        b.preorder();

        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(5);
        al.add(7);
        al.add(8);
        al.add(6);
        al.add(3);
        al.add(4);
        al.add(2);
        Btree nb = Btree.create(al);
        System.out.println("-----------------");
        nb.preorder();
    }
}