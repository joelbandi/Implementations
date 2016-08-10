public class Pltest{
    public static void main(String... ar){

        Plates plates = new Plates(3);


        plates.push(1);
        plates.push(2);
        plates.push(3);
        plates.push(4);



        System.out.println(plates.length()+1 + "  ->length");
        System.out.println(plates.depth()+ "   ->depth");


        
        System.out.println(plates.pop());
        System.out.println(plates.pop());
        System.out.println(plates.pop());
        System.out.println(plates.pop());
        
    }
}