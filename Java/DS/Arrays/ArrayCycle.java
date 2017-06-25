public class ArrayCycle{

    public static void main(String...a){


        System.out.println(solution(new int[]{1,2,3,5,10,4}));


    }

    public static boolean solution(int[] a){
        if(a == null || a.length == 0){
            return false;
        }

        for(int i = 0 ; i < a.length ; i++){

            if(a[i] < a.length){
                if(a[a[i]] == Integer.MIN_VALUE){
                    return true;
                }else{
                    a[i] = Integer.MIN_VALUE;
                }
            }else{
                continue;
            }

        }

        return false;
    }


}