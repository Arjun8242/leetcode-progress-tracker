class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums, k) - atmost(nums,k-1);
    }
    public int atmost(int[] nums, int k){
        int n=nums.length;
        int left=0; 
        int count=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int right=0;right<n;right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.size()>k){
                
                 map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }
}