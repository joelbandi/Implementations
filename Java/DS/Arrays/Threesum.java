import java.util.Arrays;
public class Threesum {
    public static void main(String[] args) {
        
        System.out.println(Arrays.toString(ts(new int[]{1, 4, 45, 6, 10, 8},22)));

    }

    public static int[] ts(int[] a,int target){

        if(a.length<3){
            return new int[]{};
        }



        Arrays.sort(a);
        int l,r;
        for(int i=0;i<a.length-2;i++){
            l = i+1;
            r = a.length-1;

            while(l<r){
                if(a[i]+a[l]+a[r] == target){
                    return new int[]{a[l],a[r],a[i]};
                }
                if(a[i]+a[r]+a[l] < target){
                    l++;
                }else{
                    r--;
                }
            }

        }

        return new int[]{};

        
    }
}