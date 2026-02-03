class Solution {
    public boolean isTrionic(int[] nums) {
        int n=nums.length;
        if(n<4) return false;
        for (int p = 1; p < n - 2; p++) {
            if (!Increasing(nums, 0, p)) continue;

            for (int q = p + 1; q < n - 1; q++) {
                if (Decreasing(nums, p, q) && Increasing(nums, q, n - 1)) {
                    return true;
                }
            }
        }
        return false;
        
    }
     public boolean Increasing(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] >= nums[i + 1]) return false;
        }
        return true;
    }

    public boolean Decreasing(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] <= nums[i + 1]) return false;
        }
        return true;
}
}