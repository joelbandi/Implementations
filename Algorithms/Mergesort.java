import java.util.*;
public class Mergesort {
    public static void main(String[] args) {
        

        System.out.println(Arrays.toString(mergesort(new int[]{8,7,6,5,4,3,2,1})));


    }


    public static int[] mergesort(int[] a){

        if(a.length< 2 || a == null){
            return a;
        }
        
        return mergesort(a,0,a.length-1);
    
    }



    public static int[] mergesort(int[] a,int start,int end){

        if(start >= end){
            return a;
        }

        int mid = (start+end)/2;

        mergesort(a,start,mid);
        mergesort(a,mid+1,end);

        merge(a,start,mid,end);


        return a;

    }


    //0 1 2 3 4 5
    public static void merge(int[] a,int start,int mid, int end){

        int n1 = mid-start+1;
        int n2 = end-mid;

        int[] tmp = new int[n1+n2];

        int i = start;
        int j = mid+1;
        int k = 0;

        while(i<=start && j <= end){

            if(a[i] < a[j]){
                tmp[k] = a[i];
                i++;
            }else{
                tmp[k] = a[j];
                j++;
            }
            k++;
        }

        while(i <= start ){
            tmp[k] = a[i];
            i++;
            k++;
        }

        while(j <= end ){
            tmp[k] = a[j];
            j++;
            k++;
        }

        for(int l = 0; l < tmp.length ; l++){
            a[l] = tmp[l];
        }


    }

}