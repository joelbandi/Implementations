public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] = new cache[m][n];
        
        
        
        cache[0][0] = (obstacleGrid[0][0] == 1)?  0: 1;
        
        for(int i = 1 ; i < m ; i++){
            if(obstacleCourse[i][0] == 0){
                cache[i][0] = 1;
            }else{
                break;
            }
        }
        

        for(int i = 1 ; i < n ; i++){
            if(obstacleCourse[0][i] == 0){
                cache[0][i] = 1;
            }else{
                break;
            }
        }
        
        
        
        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){


                


            }
        }
        
        
    }
}