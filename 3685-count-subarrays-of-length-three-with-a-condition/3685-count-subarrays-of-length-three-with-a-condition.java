class Solution {
    public int countSubarrays(int[] nums) {
        int subarray=0;
        for(int i=0;i<nums.length-2;i++){
            if(2*(nums[i]+nums[i+2])==nums[i+1]){
                subarray++;
            }
        }
        return subarray;
    }
}