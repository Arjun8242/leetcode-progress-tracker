class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] memo=new int[nums.length][nums.length+1];
        for(int[]arr:memo) Arrays.fill(arr, -1);
         return LIS(0,-1,nums,memo);
    }
    public int LIS(int curr_ind, int prev_ind, int[] nums, int[][] memo){
        if(curr_ind==nums.length){
            return 0;
        }
        if(memo[curr_ind][prev_ind+1]!=-1)return memo[curr_ind][prev_ind+1];
        int len=0+LIS(curr_ind+1,prev_ind,nums,memo);
        if(prev_ind==-1 || nums[curr_ind]>nums[prev_ind]){
            len=Math.max(len,1+LIS(curr_ind+1,curr_ind,nums,memo));
        }
        return memo[curr_ind][prev_ind+1]=len;

    }
}