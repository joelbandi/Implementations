import java.util.*;
public class Twosum {
    public static void main(String[] args) {
        
        System.out.println(Arrays.toString(methodtwo(new int[]{1, 4, 45, 6, 10, -8},16)));
        
    }

    // Hashtable method linear time complexity and linear space complexity
    public static int[] methodone(int[] a,int target){

        if(a.length <= 0){
            return a;
        }

        HashMap<Integer,Integer> cache = new HashMap<Integer,Integer>();

        for(int i = 0; i< a.length;i++){
            if(cache.containsKey(target-a[i])){
                return new int[]{i,cache.get(target-a[i])};
            }

            cache.put(a[i],i);
        }

        return new int[]{};

    }
    // Sort first and run through array with two pointers

    public static int[] methodtwo(int[] a,int target){

        if(a.length < 2){
            return new int[]{};
        }

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        int l = 0;
        int r = a.length-1;

        while(l<r){
            if(a[l]+a[r] == target){
                return new int[]{a[l],a[r]};
            }

            if(a[l]+a[r] < target){
                l++;
            }else{
                r--;
            }
        }


        return new int[]{};



    }

}