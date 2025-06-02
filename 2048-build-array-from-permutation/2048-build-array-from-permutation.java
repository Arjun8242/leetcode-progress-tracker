class Solution {
    public int[] buildArray(int[] nums) {
        int n=nums.length;
        int[] perm=new int[n];
        for(int i=0;i<n;i++){
            perm[i]=nums[nums[i]];
        }
        return perm;
    }
}