class Solution {
    public int maxProduct(int[] nums) {
        int maxpdt=1;
        int minpdt=1;
        int ans=Integer.MIN_VALUE;
        int n=nums.length;

        for(int i=0;i<n;i++){
            if(nums[i]<0){
                int temp=maxpdt;
                maxpdt=minpdt;
                minpdt=temp;
            }

            maxpdt=Math.max(nums[i], maxpdt*nums[i]);
            minpdt=Math.min(nums[i], minpdt*nums[i]);

            ans=Math.max(ans, maxpdt);
        }
        return ans;
    }
}