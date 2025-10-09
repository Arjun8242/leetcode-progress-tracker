class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        
        // If starting or ending cell has obstacle
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1)
            return 0;

        for(int i=0;i<m;i++){
            if (obstacleGrid[i][0] == 1) break;/*If an obstacle exists in that row or column, all cells after it should be 0,
because the robot can’t pass through that obstacle.*/
            dp[i][0]=1;
        }

        for(int j=0;j<n;j++){
              if (obstacleGrid[0][j] == 1) break;/*If an obstacle exists in that row or column, all cells after it should be 0,
because the robot can’t pass through that obstacle.*/
                dp[0][j]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0; 
                }
                else{
                int down=dp[i-1][j];
                int right=dp[i][j-1];
                dp[i][j]=down+right;

                }
            }
        }
        return dp[m-1][n-1];        
        
    }
}