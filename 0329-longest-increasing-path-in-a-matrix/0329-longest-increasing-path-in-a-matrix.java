class Solution {
    int[][] dp;
    int m, n;
    int[][] dirs={{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        m=matrix.length;
        n=matrix[0].length;
        dp = new int[m][n];

        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }

        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans=Math.max(ans, dfs(matrix, i, j));
            }
        }
        return ans;
    }
    public int dfs(int[][] matrix, int i, int j){

        if(dp[i][j]!=-1) return dp[i][j];
        int max=1;//min path is the cell itself

        for(int[] d:dirs){
            int ni=i+d[0];
            int nj=j+d[1];

            if(ni>=0 && ni<m && nj>=0 && nj<n && matrix[ni][nj]>matrix[i][j]){
                max=Math.max(max, 1+dfs(matrix, ni, nj));
            }
        }
        dp[i][j]=max;
        return dp[i][j];
    }
}