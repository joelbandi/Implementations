import java.util.Arrays;
public class MatrixRotate {

    public static void main(String[] args) {
        
        int[][] a = new int[][]{{1,2,3},
                                {4,5,6},
                                {7,8,9}};
        

        pr(a);
        System.out.println();
        rotate(a);
        System.out.println();
        pr(a);

    }

    public static void rotate(int[][] a){

        for(int i = 0; i< a.length/2 ; i++){

            for(int j = i; j< a[i].length-1; j++){

                //backups
                int top = a[i][j];
                int right = a[j][a[i].length-1];
                int bottom = a[a.length-1-i][a[i].length-1-j];
                int left = a[a[i].length-1-j][i];

                //replace
                a[i][j] = left;
                a[j][a[i].length-1] = top;
                a[a.length-1-i][a[i].length-1-j] = right;
                a[a[i].length-1-j][i] = bottom;


                  
            }



        }

    }

    public static void pr(int[][] a){
        for(int i = 0; i<a.length; i++){
            System.out.println(Arrays.toString(a[i]));
        }
    }

}