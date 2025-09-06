class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        for (int i = 0; i < n; i++) {
            nums[i] = (nums[i] == maxVal) ? 1 : 0;
        }
        long total = (long) n * (n + 1) / 2;
        return total - atmost(nums, k - 1);/* the number of subarray where max appeared atleast k times is = total no. of subaaray - those subarray where max appeared k - 1 times*/
    }

    public long atmost(int[] nums, int k) {
        int n = nums.length;
        long count = 0;
        int ones = 0, left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] == 1) ones++;
            while (ones > k) {
                if (nums[left] == 1) ones--;
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}