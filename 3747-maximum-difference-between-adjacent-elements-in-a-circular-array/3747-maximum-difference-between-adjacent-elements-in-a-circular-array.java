class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n=nums.length;
        int diff=Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            if(i==n-1){
                diff=Math.max(diff,Math.abs(nums[i]-nums[n-i-1]));
            }
             diff=Math.max(diff,Math.abs(nums[i]-nums[i-1]));
        }
        return diff;
    }
}