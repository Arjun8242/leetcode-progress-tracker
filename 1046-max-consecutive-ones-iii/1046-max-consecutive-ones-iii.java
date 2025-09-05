class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int left=0,right=0,zeroes=0;
        int result=0;
        for(right=0;right<n;right++){
            if(nums[right]==0){
                zeroes++;
            }
            if(zeroes>k){
                if(nums[left]==0){
                    zeroes--;
                }
                left++;
            }
            int windowlen=right-left+1;
            result=Math.max(result,windowlen);
        }
        return result;
    }
}