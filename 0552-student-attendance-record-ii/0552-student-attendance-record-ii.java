class Solution {

    int MOD=1000000007;
    Integer[][][] dp;
    public int checkRecord(int n) {
        dp=new Integer[n][2][3];
        return solve(0, 0, 0, n);
    }

    public int solve(int ind, int Aused, int Lused, int n){
        if(ind==n)return 1;

        if(dp[ind][Aused][Lused]!=null) return dp[ind][Aused][Lused];

        int ans=0;

        ans=(ans+solve(ind+1, Aused, 0, n))%MOD;

        if(Aused==0) ans=(ans+solve(ind+1, Aused+1, 0, n))%MOD;

        if(Lused< 2)ans=(ans+solve(ind+1, Aused, Lused+1, n))%MOD;

        return dp[ind][Aused][Lused]=ans;


    }
}