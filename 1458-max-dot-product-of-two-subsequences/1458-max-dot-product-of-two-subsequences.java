class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int[][] dp=new int[m+1][n+1];
        for(int[] arr:dp){
            Arrays.fill(arr, Integer.MIN_VALUE/10);
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int take=Math.max(nums1[i-1]*nums2[j-1], dp[i-1][j-1]+nums1[i-1]*nums2[j-1]);
                int skip=Math.max(dp[i-1][j], dp[i][j-1]);
                dp[i][j]=Math.max(take, skip);
            }
        } 
        return dp[m][n];
    }
}