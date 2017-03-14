import java.util.Arrays;
public class MergeSrt {
    public static void main(String[] args) {
        int[] array = new int[]{38,27,43,55,78,29,7,11};


        int[] res = solution(array);

        System.out.println(Arrays.toString(res));
    }


    public static int[] solution(int[] array){

        if(array.length <= 1){
            return array;
        }

        int[] leftarray = new int[array.length/2];
        int[] rightarray = new int[array.length-array.length/2];

        System.arraycopy(array,0,leftarray,0,leftarray.length);
        System.arraycopy(array,(array.length/2),rightarray,0,rightarray.length);
        

        return merge(solution(leftarray),solution(rightarray));

    }

    public static int[] merge(int[] a, int[] b){

        int[] newarray = new int[a.length+b.length];
        int[] larger = (a.length>=b.length)? a : b;
        int[] smaller = (a.length>=b.length)? b : a;

        int index = 0;
        int i = 0;
        int j = 0;

        while(i<smaller.length && j< larger.length){
            if(smaller[i] <= larger[j]){
                newarray[index] = smaller[i];
                index++;
                i++;
            }else{
                newarray[index] = larger[j];
                index++;
                j++;
            }
        }



        if(i<smaller.length){
            while(i<smaller.length){
                newarray[index] = smaller[i];
                index++;
                i++;
            }
        }


        if(j<larger.length){
            while(j<larger.length){
                newarray[index] = larger[j];
                index++;
                j++;
            }
        }

        return newarray;

    }

}