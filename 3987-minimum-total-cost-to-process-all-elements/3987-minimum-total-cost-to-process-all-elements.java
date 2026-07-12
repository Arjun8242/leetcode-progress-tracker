class Solution {
    public int minimumCost(int[] nums, int k) {
        long cost=0;
        long initialk=k;
        long opsperformed=0;
        long MOD = 1_000_000_007L;

        for(int num:nums){
            if(initialk<num){
                long need=num-initialk;
                long opr = need / k;
                if (need % k != 0) {
                    opr++;
                }
                initialk=k*opr+initialk-num;

                // to avoid overflow take in a and b then do MOD
                long a = opr;
                long b = 2 * opsperformed + opr + 1;

                //one of this is always even
                if ((a & 1) == 0) {
                    a /= 2;
                } else { 
                    b /= 2;
                }
                cost = (cost + (a % MOD) * (b % MOD)) % MOD;
                opsperformed+=opr;
                // initialk+=opr*k;
            }

            else initialk-=num;

        }

        return (int)(cost%MOD);
    }
}