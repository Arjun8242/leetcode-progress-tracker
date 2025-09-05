class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int left=0,right=0,zeroes=0;
        int result=0;
        for(right=0;right<n;right++){
            if(nums[right]==0){
                zeroes++;
            }
            int windowlen=right-left+1;
            if(zeroes>k){
                if(nums[left]==0){
                    zeroes--;
                }
                left++;
            }
            result=Math.max(result,right-left+1);
        }
        return result;
    }
}