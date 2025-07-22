class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> hashset=new HashSet<>();
        int  left=0, right=0, maxsum=0, currsum=0;
        while(right<nums.length){
            if(!hashset.contains(nums[right])){
            hashset.add(nums[right]);
            currsum+=nums[right];
            maxsum=Math.max(currsum,maxsum);
            right++;
            }
            else{
                hashset.remove(nums[left]);
                currsum-=nums[left];
                left++;

            }
        }
        return maxsum;
             
    }
}