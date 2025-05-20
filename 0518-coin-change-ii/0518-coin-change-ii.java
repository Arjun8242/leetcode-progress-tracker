class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int [][] dp=new int [n][amount+1];
        for(int row[]:dp){
        Arrays.fill(row,-1);}
        return counttotalways(coins,0 ,amount,dp);
    }
    static int counttotalways(int[] coins, int ind, int target, int[][]dp){
        if(target==0)return 1;
        if(ind==coins.length) return 0;
        if(dp[ind][target]!=-1) return dp[ind][target];

        int np=counttotalways(coins,ind+1,target,dp);
        int p=0;
        if(target>=coins[ind]){
            p=counttotalways(coins, ind, target-coins[ind],dp);}

        return dp[ind][target]=np+p;
    }
}