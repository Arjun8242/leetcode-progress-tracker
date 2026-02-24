class Solution {
    // int m;
    // int n;
    // Long[][][] dp;
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int m=nums1.length;
        int n=nums2.length;
        Long NEG=Long.MIN_VALUE/2;
        long[][][] dp=new long[m+1][n+1][k+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                for(int t=1;t<=k;t++){
                    dp[i][j][t]=NEG;
                }
            }
        }

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                for(int t=1;t<=k;t++){
                    long pick=1L*nums1[i]*nums2[j]+dp[i+1][j+1][t-1];
                    long skip1=dp[i+1][j][t];
                    long skip2=dp[i][j+1][t];

                    dp[i][j][t]=Math.max(pick, Math.max(skip1, skip2));
                }
            }
        }

        return dp[0][0][k];

        // return memo(nums1, nums2, 0, 0, k);
    }

    // public long memo(int[] nums1, int[] nums2, int i, int j, int k){
    //     if(k<=0) return 0;
    //     if(i>=m || j>=n) return Long.MIN_VALUE/2;

    //     if(dp[i][j][k]!=null) return dp[i][j][k];

    //     long pick=1L*nums1[i]*nums2[j]+memo(nums1, nums2, i+1, j+1, k-1);
    //     long skip1=memo(nums1, nums2, i+1, j, k);
    //     long skip2=memo(nums1, nums2, i, j+1, k);

    //     return dp[i][j][k]=Math.max(pick, Math.max(skip1, skip2));
    // }
}