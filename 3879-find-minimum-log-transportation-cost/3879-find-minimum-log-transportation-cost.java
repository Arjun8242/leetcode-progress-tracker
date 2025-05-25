class Solution {
    public long minCuttingCost(int n, int m, int k) {
        
        if(n<=k && m<=k) return 0;
        else{
            if(n>k)return (long)k*(n-k);
            return (long)k*(m-k);
        }
    }
}