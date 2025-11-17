class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] temp=new int[n+2];
        temp[0]=1;
        temp[temp.length-1]=1;
        for(int idx=0;idx<n;idx++){
            temp[idx+1]=nums[idx];
        }
        int[][] dp=new int[n+1][n+1];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        return solve(temp, 1, nums.length, dp);
    }
    public int solve(int[] temp, int i, int j, int[][] dp){
        if(i>j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int ans=Integer.MIN_VALUE;

        for(int k=i;k<=j;k++){
            ans=Math.max(ans, temp[i-1]*temp[k]*temp[j+1] + solve(temp, i, k-1, dp) + solve(temp, k+1, j, dp));
        }
        dp[i][j]=ans;

        return dp[i][j];
    }
}