class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        int ans1=robII(nums,0,nums.length-1);
        int ans2=robII(nums,1,nums.length);
        return Math.max(ans1,ans2);
    }
    public int robII(int[] nums,int first, int last){
        int rob=nums[first],no_rob=0;
        for(int i=first+1;i<last;i++){
            int Rob=no_rob+nums[i];
            int No_rob=Math.max(no_rob,rob);
            rob=Rob;
            no_rob=No_rob;
        }
        return Math.max(rob,no_rob);
    }
}