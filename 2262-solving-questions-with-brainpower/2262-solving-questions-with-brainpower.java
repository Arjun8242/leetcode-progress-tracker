class Solution {
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        long[] dp=new long[n+1];
        Arrays.fill(dp,-1);
        return solve(0,questions,dp);
    }
    public long solve(int ind, int[][] questions,long[] dp){
        if(ind>=questions.length){
            return 0;
        }
        if(dp[ind]!=-1) return dp[ind];
         
         long solve=questions[ind][0]+solve(ind+questions[ind][1]+1,questions,dp);
         long skip=0+solve(ind+1,questions,dp);
         dp[ind]=Math.max(solve,skip);
         return dp[ind];
    }
}