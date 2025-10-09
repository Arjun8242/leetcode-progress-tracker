class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
    //     int[][] dp=new int[m][n];
    //     for (int[] row : dp)
    //         Arrays.fill(row, -1);
    //     return DP(m-1, n-1, dp, grid);
    // }
    // public int DP(int i, int j, int[][] dp, int[][]grid){
    //     if(i==0 && j==0) return grid[0][0];
    //     if(i<0 || j<0) return (int)1e9;
    //     if(dp[i][j]!=-1) return dp[i][j];

    //     int up=grid[i][j]+DP(i-1, j, dp, grid);
    //     int left=grid[i][j]+DP(i, j-1, dp, grid);

    //     return dp[i][j]=Math.min(up, left);
        int[][] dp=new int[m][n];
        dp[0][0]=grid[0][0];

        // if u go right then add sum along the edges
        for(int i=1;i<m;i++){
            dp[i][0]=grid[i][0]+dp[i-1][0];
        }

        // if u go down then add sum along the edges
        for(int j=1;j<n;j++){
             dp[0][j]=grid[0][j]+dp[0][j-1]; 
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                int down=grid[i][j]+dp[i-1][j];
                int right=grid[i][j]+dp[i][j-1];
                dp[i][j]=Math.min(down, right);
            }
        }
        return dp[m-1][n-1];


        // super optimised version of code no space complexity as no dp arr initialised
        // for (int i = 1; i < m; i++) {
        //     grid[i][0] += grid[i-1][0];
        // }
        
        // for (int j = 1; j < n; j++) {
        //     grid[0][j] += grid[0][j-1];
        // }
        
        // for (int i = 1; i < m; i++) {
        //     for (int j = 1; j < n; j++) {
        //         grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
        //     }
        // }
        
        // return grid[m-1][n-1];

    }
}