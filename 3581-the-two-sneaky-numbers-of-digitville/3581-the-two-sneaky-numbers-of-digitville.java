class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int[] ans=new int[2];
        for(int i=0, j=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                ans[j]=nums[i];
                j++;
            } else{
                set.add(nums[i]);
            }
        }
        return ans;
    }
}