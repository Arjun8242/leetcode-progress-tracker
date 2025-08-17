class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod=1000000007;
        int rows=queries.length;
        for(int i=0;i<rows;i++){
            int j=queries[i][0];
            while(j<=queries[i][1]){
                nums[j]=(int)(((long)nums[j]*queries[i][3])%mod);
                j+=queries[i][2];
            }
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans^=nums[i];
        }
        return ans;
    }
}