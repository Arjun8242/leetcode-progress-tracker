class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        int longest=0;

        for(int num:set){
            if(!set.contains(num-1)){//to stop starting seq from every number
                int len=1;
                
                while(set.contains(num+len)){
                    len++;
                }
                longest=Math.max(longest, len);
            }
        }
        return longest;
    }
}