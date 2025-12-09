class Solution {
    public int maxSubArray(int[] nums) {
        int ans=Integer.MIN_VALUE;
        int sum=0;
        int n=nums.length;
        if(n==1) return nums[0];
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
            ans=Math.max(ans, sum);
            if(sum<0) sum=0;
        }
        return ans;
    }
}