class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve_dp(n-1,nums,dp);
    }
    public int solve_dp(int ind,int[] arr,int[] dp){
        if(ind==0)
        return arr[ind];

        if(ind<0)return 0;

          if(dp[ind]!=-1)
        return dp[ind];

        int pick=arr[ind]+solve_dp(ind-2,arr,dp);
        int notpick=0+solve_dp(ind-1,arr,dp);

        return dp[ind]=Math.max(pick,notpick);
            }
}