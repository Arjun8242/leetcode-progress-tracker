class Solution {
    public int subarraySum(int[] nums, int k) {
         int sum=0, left=0, right=0, ans=0, n=nums.length;
         HashMap<Integer, Integer> map=new HashMap<>();
           // Initialize with 0 -> 1
        // This represents the "empty subarray" before starting
        // It ensures we correctly count subarrays that start at index 0
         map.put(0,1);
        for(right=0;right<n;right++){
            sum+=nums[right];
            if(map.containsKey(sum-k)){
                ans+=map.getOrDefault(sum-k, 0);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}