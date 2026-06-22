class Solution {
    private static final long MOD = 1_000_000_007L;
    public int maxTotalValue(int[] value, int[] decay, int m) {
        long lo=1;
        long hi=1_000_000_000L;
        int n=value.length;

        while(lo<=hi){
            long mid=(lo+hi)/2;
            if(count(mid, value, decay)>=m){
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }

        long Thres=hi;
        long used=0;
        long ans=0;

        for(int i=0;i<n;i++){
            if(value[i]<=Thres) continue;

            long k = (value[i] - (Thres + 1)) / decay[i] + 1;
            long last = value[i] - (k - 1) * (long)decay[i];
            long sum = k * (value[i] + last) / 2;
            ans = (ans + sum % MOD) % MOD;
            used+=k;
        }

        long remain=m-used;
        ans = (ans + (remain % MOD) * (Thres % MOD)) % MOD;
        return (int)ans;
    }
    private long count(long X, int[] value, int[] decay){
        int n=value.length;
        long count=0;

        for(int i=0;i<n;i++){
            if(value[i]<X) continue;

            count+=(value[i]-X)/decay[i]+1;
        }

        return count;
    }
}