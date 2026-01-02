class Solution {
    public int repeatedNTimes(int[] nums) {
        int n=nums.length;
        if(nums[0]==nums[3]) return nums[0];
        for(int i=0;i<n;i++){
            if(nums[i]==nums[i+1] || nums[i]==nums[i+2]){
                return nums[i];
            }
        }
        return 0;
    }
}