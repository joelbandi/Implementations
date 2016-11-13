public class ModifiedFibo {
    public static void main(String[] args) {

        //011237
        System.out.println(solution1(0,1,5));
        System.out.println(solution2(0,1,5));
        System.out.println(solution3(0,1,5));
        
    }


    // top down recursive DP approach with memoization
    public static int solution1(int a,int b,int c){
        return solution1(a,b,c,new int[c+1]);
    }
    public static int solution1(int a,int b,int c,int[] cache){

        if(c==0){
            return a;
        }
        if(c==1){
            return b;
        }

        if(cache[c] == 0){
            cache[c] = solution1(a,b,c-1,cache)+(int)Math.pow(solution1(a,b,c-2,cache),2);
        }

        return cache[c];

    }

    // bottom up approach iterative DP approach with memoization
    public static int solution2(int a,int b,int c){


        int[] cache = new int[c+1];
        cache[0] = a;
        cache[1] = b;

        for(int i = 2; i< cache.length ; i++){

            cache[i] = cache[i-1] +(int) Math.pow(cache[i-2],2);

        }

        return cache[c];
    }


    // even better bottom up approach with constant space complexity
    public static int solution3(int a,int b,int c){

        int _c = c;

        for(int i = 2; i <= _c; i++){

            c = b + (int) Math.pow(a,2);
            a = b;
            b = c;

        }

        return c;

    }


}