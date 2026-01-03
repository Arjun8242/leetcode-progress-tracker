class Solution {
    static final long MOD=1_000_000_007L;
        Long[][] memo;
    public int numOfWays(int n) {
        memo=new Long[n+1][2];
        long A=solve(n, 0);
        long B=solve(n, 1);

        return (int)((A+B)%MOD);
    }
    public long solve(int row, int type){
        if(row==1) return 6;

        if(memo[row][type]!=null) return memo[row][type];

        long res=0;
        
        if(type==0){
            res=(2*solve(row-1, 0)+2*solve(row-1, 1))%MOD;
        }
        else{
            res=(2*solve(row-1, 0)+3*solve(row-1, 1))%MOD;
        }
        memo[row][type]=res;
        return res;
    }
}