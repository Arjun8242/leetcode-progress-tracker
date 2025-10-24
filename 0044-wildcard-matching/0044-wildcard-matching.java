class Solution {
    public boolean isMatch(String s, String p) {
        int n1=s.length();
        int n2=p.length();
        Boolean[][] dp=new Boolean[n1][n2];
        return recursion(n1-1, n2-1, s, p, dp);
    }
    public boolean recursion(int ind1, int ind2, String s, String p, Boolean[][] dp){
        if(ind1<0 && ind2<0) return true;
        if(ind1>=0 && ind2<0) return false;
        if(ind1<0 && ind2>=0){
            for(int i=0;i<=ind2;i++){
                if(p.charAt(i)!='*') return false;
            }
            return true;
        }

        if (dp[ind1][ind2] != null) return dp[ind1][ind2];

        if(s.charAt(ind1)==p.charAt(ind2) || p.charAt(ind2)=='?'){
            dp[ind1][ind2] = recursion(ind1-1, ind2-1, s, p, dp);
        }
        else if(p.charAt(ind2)=='*'){
            dp[ind1][ind2] = recursion(ind1-1, ind2, s, p, dp) || recursion(ind1, ind2-1, s, p, dp);
        }
        else{
            dp[ind1][ind2]=false;
        }
        return dp[ind1][ind2];
    }
}