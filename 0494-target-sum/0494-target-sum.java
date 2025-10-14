class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int totsum=0;
        for(int i=0;i<n;i++){
            totsum+=nums[i];
        }
        
        if(totsum<target || (totsum+target)%2==1)
        return 0;

        if(totsum+target<0) return 0;
        
        int k=(totsum+target)/2;
        int[][] dp=new int[n][k+1];
        
        
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        
        if(nums[0]==0){
            dp[0][0]=2;
        }
        else{
            dp[0][0]=1;
            if(nums[0]<=k) dp[0][nums[0]]=1;
        }
        
        for(int i=1;i<n;i++){
            for(int d=0;d<=k;d++){
                int nottaken=dp[i-1][d];
                int taken=0;
                if(nums[i]<=d){
                    taken=dp[i-1][d-nums[i]];
                }
                dp[i][d]=nottaken+taken;
            }
        }
        return dp[n-1][k];
    }
}