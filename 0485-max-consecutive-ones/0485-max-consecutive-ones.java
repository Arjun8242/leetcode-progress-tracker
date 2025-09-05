class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
         int left = 0, right = 0, n = nums.length;
        int result = 0;
        for(right=0; right<n; right++){ 
            if (nums[right] == 0) {
                left = right + 1;
            }
            result = Math.max(result, right - left + 1);

        }

        return result;
    }
}