class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        int left=0;
        int count=0;
        int pdt=1;

        for(int right=0;right<n;right++){
            pdt*=nums[right];
            while(pdt>=k){
                if(left>right) break;
                pdt/=nums[left];
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }
}