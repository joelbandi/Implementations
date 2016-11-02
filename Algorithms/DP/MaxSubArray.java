// even works for completely negative arrays....unlike kadane's algorithm.
import java.util.Arrays;
public class MaxSubArray {
    public static void main(String[] args) {
        
        System.out.println(solution(new int[]{-1,-2,3,-5}));


    }

    public static int solution(int[] arr){

        int currentmax = 0-Integer.MAX_VALUE;
        int globalmax = 0-Integer.MAX_VALUE;

        for(int i = 0; i< arr.length ; i++){

            currentmax = Math.max(arr[i],currentmax+arr[i]);
            globalmax = Math.max(globalmax,currentmax);

        }

        return globalmax;

    }


}