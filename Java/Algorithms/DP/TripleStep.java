public class TripleStep {
    

    public static void main(String[] args) {


        for(int k = 0; k < 20 ; k++){
            System.out.println(solution(k,new int[k+1]));
        }

        for(int k = 0; k < 20 ; k++){
            System.out.println(solution2(k));
        }

        for(int k = 0; k < 20 ; k++){
            System.out.println(solution3(k));
        }

    }



    public static int solution(int n,int[] cache){
        // 1 step / 2 step / 3 step
        // / top-down recursive + DP approach with memoization


        if(n<=0){
            return 0;
        }

        if(n<=1){
            return 1;
        }

        if(n<=2){
            return 3;
        }

        if(cache[n] == 0){
            cache[n]=solution(n-1,cache)+solution(n-2,cache)+solution(n-3,cache);
        }

        return cache[n];

    }

    public static int solution2(int n){
        //bottom-up iterartive approach
        if(n ==1 | n == 0){
            return n;
        }

        if(n == 2 ){
            return 3;
        }

        int[] cache = new int[n+1];
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 3;


        for(int i = 3; i<=n; i++){
            cache[i] = cache[i-1]+cache[i-2]+cache[i-3];
        }


        return cache[n];
    }

    public static int solution3(int n){
        //bottom-up iterartive approach
        if(n ==1 | n == 0){
            return n;
        }

        if(n == 2 ){
            return n+1;
        }

        int a = 0;
        int b = 1;
        int _b = 1;
        int c = 3;


        for(int i = 3; i<=n; i++){
            c = c + b + a;
            b = c - b - a;
            a = _b;
            _b = b;
        }


        return c;
    }




}