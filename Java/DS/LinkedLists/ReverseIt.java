public class ReverseIt {
    
    public static void main(String[] args) {
        


        Noid n = new Noid(1);
        n.next = new Noid(2);
        n.next.next = new Noid(3);
        n.next.next.next = new Noid(4);
        n.next.next.next.next = new Noid(5);


        n = solution(n);


        while(n.next != null){
            System.out.print(n.value+ "->");
            n=n.next;
        }

        System.out.print(n.value);


        
    }

    public static Noid solution(Noid n){

        Noid head = n;
        Noid one = n;
        Noid two = one.next;
        Noid three = two.next;


        while(three.next != null){


            two.next = one;


            one = two;
            two = three;
            three = three.next;



        }

        two.next = one;
        three.next = two;
        head.next = null;

        return three;

    }





    public static class Noid {
        int value;
        Noid next;

        Noid(int value){
            this.value = value;
            this.next = null;
        }
    }
}