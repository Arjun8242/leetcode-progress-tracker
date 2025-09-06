class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
         return atmost(nums, k) - atmost(nums, k-1);
    }
    public int atmost(int[] nums, int k){
         int n=nums.length;
        int count=0, ones=0, left=0;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0) nums[i]=0;
            else nums[i]=1;
        }
        for(int right=0;right<n;right++){
            if(nums[right]==1) ones++;
            while(ones>k){
                if(nums[left]==1) ones--;
                left++;
            }
               count+=right-left+1;
        }
        return count;
    }
}