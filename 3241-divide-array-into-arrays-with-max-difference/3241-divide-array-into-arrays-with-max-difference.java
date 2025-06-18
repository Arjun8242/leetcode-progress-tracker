class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int[][] ans=new int[n/3][3];
        int j=0;
            for(int i=0;i<n-2;i+=2){
                if(i + 2 < n && nums[i + 2] - nums[i] <= k){
                    ans[j][0]=nums[i];
                    ans[j][1]=nums[i+1];
                    ans[j][2]=nums[i+2];
                    i++;
                    j++;
                }
                else{
                    return new int[0][0];
                }
            }
            return ans;
    }
}