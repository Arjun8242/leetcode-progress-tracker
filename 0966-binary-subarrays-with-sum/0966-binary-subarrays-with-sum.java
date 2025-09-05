class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
      return func(nums, goal) - func(nums, goal-1);
    }
    public int func(int[] nums, int goal){
        if(goal<0) return 0;
         int sum=0, left=0, right=0, count=0, n=nums.length;
        for(right=0;right<n;right++){
            sum+=nums[right];
            
            while(sum>goal){
                sum-=nums[left];
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }
}