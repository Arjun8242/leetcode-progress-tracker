class Solution {
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();
        int[][] dp = new int[m+1][n+1];
    //     for(int[] row: dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return DP(0, 0, s, t, dp);
    // }
    // public int DP(int i, int j, String s, String t, int[][] dp){
    //     if(j==t.length()) return 1;
    //     if(i==s.length() && j<t.length()) return 0;

    //     if(dp[i][j]!=-1) return dp[i][j];

    //     int pick=0;
    //     if(s.charAt(i)==t.charAt(j)){
    //         pick = DP(i+1, j+1, s, t, dp);
    //     }
    //     int notpick = DP(i+1, j, s, t, dp);

    //     dp[i][j]=pick+notpick;
        
    //     return dp[i][j];
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
    
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int pick=0;
                int notpick=0;
                if(s.charAt(i-1)==t.charAt(j-1)){
                    pick=dp[i-1][j-1]+dp[i-1][j];;
                }
                else{
                    notpick=dp[i-1][j];
                }

                dp[i][j]=pick+notpick;
            }
        }
        return dp[m][n];
    }
}