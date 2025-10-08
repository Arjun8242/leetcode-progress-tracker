import java.util.*;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int ans1 = DP(1, n - 1, nums);  // exclude first house
        int ans2 = DP(0, n - 2, nums);  // exclude last house

        return Math.max(ans1, ans2);
    }

    public int DP(int start, int end, int[] nums) {
        if (start == end) return nums[start]; 
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            int take = nums[i] + dp[i - 2];
            int notTake = dp[i - 1];
            dp[i] = Math.max(take, notTake);
        }

        return dp[end];
    }
}
