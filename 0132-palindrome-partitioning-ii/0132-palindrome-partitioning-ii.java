class Solution {
    public int minCut(String s) {
        int[] dp=new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(s, 0, s.length()-1, dp)-1;
    }
    public int solve(String s, int i, int j, int[] dp){
        if(i>j) return 0;

        if(dp[i]!=-1) return dp[i];

        int mincut=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            if(palindrome(s, i, k)){
                int cuts=1+solve(s, k+1, j, dp);
                mincut=Math.min(cuts, mincut);
            }
        }
        dp[i]=mincut;
        return dp[i];
    }
    public boolean palindrome(String s, int i, int k){
        while (i < k) {
        if (s.charAt(i) != s.charAt(k)) {
            return false;
        }
        i++;
        k--;
    }
    return true;
    }
}