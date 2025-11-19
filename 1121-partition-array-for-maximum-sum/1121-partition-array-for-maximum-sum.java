class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp=new int[arr.length+1];
        Arrays.fill(dp, -1);
        return solve(arr, k, 0, dp);
    }
    public int solve(int[] arr, int k, int i, int[] dp){
        if(i==arr.length) return 0;

        if(dp[i]!=-1) return dp[i];

        int max=Integer.MIN_VALUE;
        int len=0, sum=0;
        for(int t=i;t<Math.min(i+k, arr.length);t++){
            len++;
            max=Math.max(max, arr[t]);
            sum=Math.max(sum, (max*len)+solve(arr, k, t+1, dp));
        }
        dp[i]=sum;
        return dp[i];
    }
}