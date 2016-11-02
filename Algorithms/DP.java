import java.util.*;
public class DP {
    //Explain the concepts of DP using Fibonacci number

    public static void main(String[] args) {

        int res = fibo_top_down(14,new int[15]);
        System.out.println(res);

        int[] res2 = fibo_bottom_up(14);
        System.out.println(Arrays.toString(res2));

        int res3 = fibo_bottom_up_upgrade(14);
        // System.out.println(res3);

        
        
    }


    public static int fibo_top_down(int n,int[] cache){
        if(n==0 || n==1){
            return n;
        }

        if(cache[n] == 0){
            cache[n] = fibo_top_down(n-1,cache)+fibo_top_down(n-2,cache);
        }

        return cache[n];

    }


    public static int[] fibo_bottom_up(int n){

        
        int[] cache = new int[n+1];
        cache[0] = 0;
        cache[1] = 1;


        for(int i =2; i<= n ; i++){
            cache[i] = cache[i-1]+cache[i-2];
        }

        return cache;
        
    }


    public static int fibo_bottom_up_upgrade(int n){

        if(n == 0 || n == 1){
            return n;
        }
        
        int a = 0;
        int b = 1;

        for(int i = 2; i<= n ; i++){

            b = a+b;
            a = b-a;
            System.out.print(" "+b);

        }
        System.out.println();

        return 0;
    }

}