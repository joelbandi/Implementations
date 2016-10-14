// Bit level manipulations and shift operators.
public class BitManip {
    public static void main(String[] args) {
        

        int[] ar = new int[] {1,2,3,1,6,2,3};
        int k = ar[0];
        for(int i = 1; i< ar.length ; i++){
            k = k^ar[i];
        }

        System.out.println(k);

        System.out.println(Integer.toString(0b10>>1,10));


    }
}