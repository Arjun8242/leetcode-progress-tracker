class Solution {
    /*public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int [][] dp=new int [n][amount+1];
        for(int row[]:dp){
        Arrays.fill(row,-1);}
        int ans=minchange(coins,0,amount,dp);
        return ans>=(int)1e9?-1:ans;
    }
    public static int minchange(int[] coins, int ind, int target, int[][] dp){
        if(target==0) return 0;
        if(ind==coins.length) return (int)1e9;
                if(dp[ind][target]!=-1)return dp[ind][target];

        int np=0+minchange(coins,ind+1,target,dp);
        int p=(int)1e9;
        if(target>=coins[ind]){
            p=1+minchange(coins, ind, target-coins[ind],dp);
        }
        return dp[ind][target]=(Math.min(p,np));
    }*/

        public int coinChange(int[] coins, int amount) {
             int n=coins.length;
        int [][] dp=new int [n][amount+1];
        //filling the first row [0] for dp array
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0)
            dp[0][i]=i/coins[0];
            else{
                dp[0][i]=(int)1e9;
            }
        }

        //filiing the whole dp array
         for(int ind=1;ind<n;ind++){
            for(int T=0;T<=amount;T++){
                int np=0+dp[ind-1][T];
                int p=(int)1e9;
                if(T>=coins[ind]){
                    p=1+dp[ind][T-coins[ind]];
                }
                dp[ind][T]=Math.min(np,p);
                }
         }
         int ans=dp[n-1][amount];

         return ans>=(int)1e9?-1:ans;
}
}