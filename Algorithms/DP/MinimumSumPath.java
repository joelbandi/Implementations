// better then MaximumSumPath's implementation'
public class MinimumSumPath {
    public static void main(String[] args) {

        System.out.println(solution(new int[][]{{1,5,6},{2,3,5},{7,8,4}}));

    }


    public static int solution(int[][] grid){

        if(grid == null || grid.length == 0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] cache = new int[m][n];
        cache[0][0] = grid[0][0];



        // top most row
        for(int i = 1; i< n; i++){
            cache[0][i] = cache[0][i-1] + grid[0][i];
        }

        // leftmost column fill it up
        for(int i = 1 ; i< m; i++){
            cache[i][0] = cache[i-1][0] + grid[i][0];
        }


        // now do the rest of things!!
        for(int i = 1 ; i < m; i++){

            for(int j = 1; j < n ; j++){

                // cache[i][j] = Math.max(cache[i-1][j],cache[i][j-1]) + grid[i][j];
                cache[i][j] = Math.min(cache[i-1][j],cache[i][j-1]) + grid[i][j];

            }

        }

        return cache[m-1][n-1];



    }

}