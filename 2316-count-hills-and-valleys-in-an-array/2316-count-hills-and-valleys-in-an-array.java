class Solution {
    public int countHillValley(int[] nums) {
        int handv=0;
        int prev=nums[0];
        if(nums.length<=2) return 0;
        for(int i=1;i<nums.length-1;i++){
            if((nums[i]<prev && nums[i+1]>nums[i]) || (nums[i]>prev && nums[i+1]<nums[i])) handv++;
            if(nums[i]!=nums[i+1]) prev=nums[i];
            }
        return handv;
    }
}