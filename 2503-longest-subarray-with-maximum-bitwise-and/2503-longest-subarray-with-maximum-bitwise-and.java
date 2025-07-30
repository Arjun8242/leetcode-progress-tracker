class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
        }

        int templength=0;
        int len=0;
        for(int i=0;i<n;i++){
            if(nums[i]==max){
                templength++;
            } else{
                len=Math.max(len,templength);
                templength=0;
            }
        }
        return Math.max(len,templength);
    }
}