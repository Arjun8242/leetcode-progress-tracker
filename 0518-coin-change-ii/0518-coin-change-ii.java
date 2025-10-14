class Solution {
    public int change(int amount, int[] coins) {
    //     int n=coins.length;
    //     int [][] dp=new int [n][amount+1];
    //     for(int row[]:dp){
    //     Arrays.fill(row,-1);}
    //     return counttotalways(coins,0 ,amount,dp);
    // }
    // static int counttotalways(int[] coins, int ind, int target, int[][]dp){
    //     if(target==0)return 1;
    //     if(ind==coins.length) return 0;
    //     if(dp[ind][target]!=-1) return dp[ind][target];

    //     int np=counttotalways(coins,ind+1,target,dp);
    //     int p=0;
    //     if(target>=coins[ind]){
    //         p=counttotalways(coins, ind, target-coins[ind],dp);}

    //     return dp[ind][target]=np+p;
       int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0)
                dp[0][t] = 1;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= amount; target++) {
                int notPick = dp[ind - 1][target];
                int pick = 0;
                if (coins[ind] <= target)
                    pick = dp[ind][target - coins[ind]];
                dp[ind][target] = pick + notPick;
            }
        }

        return dp[n - 1][amount];
    }
}