class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp=new int [n+1][k+1][2];//[n][trans][buy]
    //     for(int[][] arr:dp){
    //         for(int[] a:arr){
    //             Arrays.fill(a, -1);
    //         }
    //     }
    //     return recursion(0, 2, 1, n, prices, dp);
    // }
    // public int recursion(int day, int trans, int buy, int n, int[] prices,int[][][] dp){
    //     if(day==n || trans==0) return 0;

    //     if(dp[day][trans][buy]!=-1) return dp[day][trans][buy];

    //     //buying phase 
        // if(buy==1){
        //     return dp[day][trans][buy] = Math.max(-prices[day]+recursion(day+1, trans, 0, n, prices, dp), recursion(day+1, trans, 1, n, prices, dp));
        // }

        // //selling phase
        // else{
        //     return dp[day][trans][buy] = Math.max(prices[day]+recursion(day+1, trans-1, 1, n, prices, dp), recursion(day+1, trans, 0, n, prices, dp));
        // }


    // tabulated approach 

    for(int day=n-1;day>=0;day--){
        for(int trans=1;trans<=k;trans++){
            for(int buy=0;buy<=1;buy++){
                //buying phase 
                if(buy==1){
                dp[day][trans][buy] = Math.max(-prices[day]+dp[day+1][trans][0], dp[day+1][trans][1]);
                }

                //selling phase
                else{
                    dp[day][trans][buy] = Math.max(prices[day]+dp[day+1][trans-1][1], dp[day+1][trans][0]);
                    }
            }
        }
    }
    return dp[0][k][1];
    }
}