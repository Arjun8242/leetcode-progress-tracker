class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        boolean allzeroes=true;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                allzeroes = false;
                break;
            }
        }
        if(allzeroes) return 0;
         
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);

        return Math.max(0, DP(nums, dp, 0, 0));
    }

    public int DP(int[] nums, int[] dp, int idx, int tot){
        if(idx==nums.length){
            if(tot==0) return (int)-1e5;
            return 0;
        }

        if(dp[idx]!=-1) return dp[idx];

        int pick=1+DP(nums , dp, idx+1,  tot^nums[idx]);
        int notpick=DP(nums, dp, idx+1, tot);

       return dp[idx]=Math.max(0,Math.max(pick, notpick));
    }
}