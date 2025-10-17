class Solution {
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();
        int[][] dp = new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return DP(0, 0, s, t, dp);
    }
    public int DP(int i, int j, String s, String t, int[][] dp){
        if(j==t.length()) return 1;
        if(i==s.length() && j<t.length()) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int pick=0;
        if(s.charAt(i)==t.charAt(j)){
            pick = DP(i+1, j+1, s, t, dp);
        }
        int notpick = DP(i+1, j, s, t, dp);

        dp[i][j]=pick+notpick;
        
        return dp[i][j];
    }
}