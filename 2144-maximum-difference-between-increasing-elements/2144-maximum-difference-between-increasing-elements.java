class Solution {
    public int maximumDifference(int[] nums) {
        int min=nums[0];
        int diff=-1;
       for(int i=1;i<nums.length;i++){
        diff=Math.max(diff,nums[i]-min);
        min=Math.min(nums[i],min);
       }
        if(diff==0) return -1;
        else{
            return diff;
        }
    }
}