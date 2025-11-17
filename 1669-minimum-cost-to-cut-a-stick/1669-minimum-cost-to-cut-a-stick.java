class Solution {
    public int minCost(int n, int[] cuts) {
        int[] temp=new int[cuts.length+2];
        Arrays.sort(cuts);
        temp[0]=0;
        temp[temp.length-1]=n;
        for(int idx=0;idx<cuts.length;idx++){
            temp[idx+1]=cuts[idx];
        }
        int[][] dp=new int[cuts.length+2][cuts.length+2];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        return solve(temp, 1, cuts.length, dp);
    }
    public int solve(int[] temp, int i, int j, int[][] dp){
        if(i>j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int ans=Integer.MAX_VALUE;

        for(int k=i;k<=j;k++){
            ans=Math.min(ans, temp[j+1]-temp[i-1] + solve(temp, i, k-1, dp) + solve(temp, k+1, j, dp));
        }
        dp[i][j]=ans;

        return dp[i][j];
    }
}