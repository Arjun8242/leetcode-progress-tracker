class Solution {
    static final long NEG_INF = (long)-1e18;
    public long maximumProfit(int[] prices, int k) {
         int n = prices.length;
        long[][][] dp = new long[n + 1][k + 1][3]; // [day][trans][state]

        for (long[][] arr : dp) {
            for (long[] a : arr) {
                Arrays.fill(a, NEG_INF);
            }
        }

        return recursion(0, k, 0, n, prices, dp);
    }
    public long recursion(int day, int trans, int state, int n, int[] price, long[][][] dp) {

        if (day == n) {
            if (state == 0) return 0;
            return NEG_INF;
        }

        if (dp[day][trans][state] != NEG_INF)
            return dp[day][trans][state];

        long pick = NEG_INF;
        long dontpick = NEG_INF;

        // flat state
        if(trans>0){
            if (state == 0) {
            pick=Math.max(pick, -price[day] + recursion(day + 1, trans , 1, n, price, dp));// long

            pick=Math.max(pick, +price[day] + recursion(day + 1, trans , 2, n, price, dp));// short 
        }

        // long state
            else if (state == 1) {
                pick = Math.max(pick, +price[day] + recursion(day + 1, trans - 1, 0, n, price, dp));// short 

            }

            // short state
            else {
                pick = Math.max(pick, -price[day] + recursion(day + 1, trans - 1, 0, n, price, dp));// long

            }
        }
        dontpick=recursion(day+1, trans, state, n, price, dp);

        return dp[day][trans][state] = Math.max(pick, dontpick);
    }
}