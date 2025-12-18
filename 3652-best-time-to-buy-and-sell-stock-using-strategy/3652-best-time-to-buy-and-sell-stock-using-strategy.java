class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n=prices.length;
        long base=0;
        for(int i=0;i<n;i++){
            base+=(long)strategy[i]*prices[i];
        }
         long[] pref1 = new long[n + 1];
        long[] pref2 = new long[n + 1];

        for(int i = 0; i < n; i++) {
            pref1[i + 1] = pref1[i] + (long)strategy[i] * prices[i];
            pref2[i + 1] = pref2[i] + (long)prices[i] - (long)strategy[i] * prices[i];
        }

        long del = 0;
        int half = k / 2;

        for(int i = 0; i + k <= n; ++i) {
            int mid  = i + half;
            int r    = i + k;

            long left  = pref1[mid] - pref1[i];
            long right = pref2[r] - pref2[mid];

            long cur = -left + right;
            if (cur > del) {
                del = cur;
            }
        }

        return base + del;

    }
}