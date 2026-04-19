class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] prefixmax=new int[n];
        int[] prefixmin=new int[n];

        prefixmax[0]=nums[0];
        for(int i=1;i<n;i++){
            prefixmax[i]=Math.max(nums[i], prefixmax[i-1]);
        }

        prefixmin[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            prefixmin[i]=Math.min(nums[i], prefixmin[i+1]);
        }

        for(int i=0;i<n;i++){
            int score=prefixmax[i]-prefixmin[i];
            if(score<=k) return i;
        }
        return -1;
    }
}