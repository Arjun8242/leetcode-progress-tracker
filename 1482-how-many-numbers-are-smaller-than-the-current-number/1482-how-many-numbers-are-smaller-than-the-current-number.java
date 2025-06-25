class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] ans=new int[nums.length];
        int[] copy=Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
        }
        for(int i=0;i<nums.length;i++){
                ans[i]=map.get(copy[i]);
        }
        return ans;

    }
}