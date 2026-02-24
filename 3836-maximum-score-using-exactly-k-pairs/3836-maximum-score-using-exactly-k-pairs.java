class Solution {
    int m;
    int n;
    Long[][][] dp;
    public long maxScore(int[] nums1, int[] nums2, int k) {
        m=nums1.length;
        n=nums2.length;
        dp=new Long[m+1][n+1][k+1];
        return memo(nums1, nums2, 0, 0, k);
    }

    public long memo(int[] nums1, int[] nums2, int i, int j, int k){
        if(k<=0) return 0;
        if(i>=m || j>=n) return Long.MIN_VALUE/2;

        if(dp[i][j][k]!=null) return dp[i][j][k];

        long pick=nums1[i]*nums2[j]+memo(nums1, nums2, i+1, j+1, k-1);
        long skip1=memo(nums1, nums2, i+1, j, k);
        long skip2=memo(nums1, nums2, i, j+1, k);

        return dp[i][j][k]=Math.max(pick, Math.max(skip1, skip2));
    }
}