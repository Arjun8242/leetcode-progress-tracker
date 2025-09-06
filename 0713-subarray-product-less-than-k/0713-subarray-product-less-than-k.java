class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left=0;  int count=0; long pdt=1;
        int n=nums.length;
        if(k<=1) return 0;
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