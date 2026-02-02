class Solution {
    public int minimumCost(int[] nums) {
        int n=nums.length;
        int sum=nums[0];
        Arrays.sort(nums, 1, nums.length);
        return sum+nums[1]+nums[2];
    }
}