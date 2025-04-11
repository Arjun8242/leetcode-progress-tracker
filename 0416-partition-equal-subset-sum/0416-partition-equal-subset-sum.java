class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }
        if(sum%2!=0)return false;
        sum=sum/2;
        Boolean[][] memo=new Boolean[nums.length+1][sum+1];
        return memoization(nums,memo,0,sum);
    }
    boolean memoization(int nums[],Boolean memo[][],int ind,int target){
        if(target==0)return true;
        if(target<0 || ind==nums.length)return false;
        if(memo[ind][target]!=null)return memo[ind][target];

        boolean pick=memoization(nums,memo,ind+1,target-nums[ind]);
        if(pick==true)return memo[ind][target]=pick;
        boolean notpick=memoization(nums,memo,ind+1,target);
        return memo[ind][target]=notpick;
    }
}
