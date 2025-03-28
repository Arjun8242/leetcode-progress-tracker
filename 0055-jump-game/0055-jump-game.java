class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return maxjump(nums,0,dp,n);
        
    }
    boolean maxjump(int[] nums, int index,int[] dp,int n){
        if(index>=n-1)return true;
        if(dp[index]!=-1)return dp[index]==0?false:true;

        for(int i=1;i<=nums[index];i++){
            if(maxjump(nums,index+i,dp,n)==true)
            {
                dp[index]=1;
                return true;
            }
        }
        dp[index]=0;
        return false;
    }
}