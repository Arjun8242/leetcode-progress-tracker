class Solution {
    public int minInsertions(String s) {
        if(ispalindrome(s)) return 0;
        int m=s.length();
        String rev="";
        for(int i=m-1;i>=0;i--){
            rev+=s.charAt(i);
        }
        int n=rev.length();
        int[][] dp=new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==rev.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return m-dp[m][n];
    }
    public boolean ispalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}