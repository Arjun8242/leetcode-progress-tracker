class Solution {
    public int maxConsistentColumns(int[][] grid, int limit) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=1;
        int[] dp=new int[n];
        dp[0]=1;

        for(int j=1;j<n;j++){
            dp[j]=1;
            for(int i=0;i<j;i++){
                boolean columncheck=true;

                for(int row=0;row<m;row++){
                    if(Math.abs(grid[row][j]-grid[row][i])>limit){
                        columncheck=false;
                        break;
                    }
                }
                if(columncheck){
                        dp[j]=Math.max(dp[j], dp[i]+1);
                }
                
                ans=Math.max(dp[j], ans);
            }
        }
        return ans;
    }
}