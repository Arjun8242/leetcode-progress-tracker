class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n=nums.length;
        Map<Integer, Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                int ind=map.get(nums[i]);

                if(Math.abs(ind - i)<=k){
                    return true;
                }
                map.put(nums[i], i);
                
            }
            else{
                map.put(nums[i], i);
            }
        }
        return false;
    }
}