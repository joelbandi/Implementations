import java.util.*;
public class CheckSubtree{
    public static void main(String... args){
        
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(5);
        al.add(7);
        al.add(8);
        al.add(6);
        al.add(3);
        al.add(4);
        al.add(2);
        Btree t1 = Btree.create(al);

        ArrayList<Integer> bl = new ArrayList<Integer>();
        bl.add(0);
        bl.add(1);
        bl.add(5);
        bl.add(7);
        bl.add(8);
        bl.add(6);
        bl.add(3);
        bl.add(4);
        bl.add(2);
        bl.add(9);
        bl.add(10);
        bl.add(11);
        
        Btree t2 = Btree.create(bl);


        System.out.println(solution(t1,t2));

    }

    public static boolean solution(Btree t1, Btree t2){
        
        String s1 = preorder(t1,new StringBuilder());
        String s2 = preorder(t2,new StringBuilder());
        System.out.println(s1+"----"+s2);


        return s2.substring(0,s2.length()-1).contains(s1.substring(0,s1.length()-1));
        

    }

    public static String preorder(Btree t,StringBuilder s){
        s.append(String.valueOf(t.value));

        
        if(t.right!= null){
            preorder(t.right,s);
        }else{
            s.append("$");
        }
        if(t.left!=null){
            preorder(t.left,s);
        }else{
            s.append("$");
        }
        return s.toString();
    }
}