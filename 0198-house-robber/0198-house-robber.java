class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        return dp(n-1, dp, nums);
    }
    public int dp(int i, int[] dp, int[] nums){
        if(i==0) return nums[i];
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];

        int pick=nums[i]+dp(i-2, dp, nums);
        int notpick=dp(i-1, dp, nums);

        return dp[i]=Math.max(pick, notpick);
    }
}