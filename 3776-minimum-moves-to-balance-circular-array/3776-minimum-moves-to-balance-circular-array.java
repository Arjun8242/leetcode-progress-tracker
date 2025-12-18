class Solution {
    public long minMoves(int[] balance) {
        int n=balance.length;
        int nindex=-1;
        for(int i=0;i<n;i++){
            if(balance[i]<0){
                nindex=i;
                break;
            }
        }
        if(nindex==-1) return 0;
        long need=-balance[nindex];
        long moves=0;

        for(int d=0;d<n && need>0;d++){
            int left=(nindex-d+n)%n;
            int right=(nindex+d)%n;

            if(balance[left]>0){
                long debt=Math.min(balance[left], need);
                balance[left]-=debt;
                need-=debt;
                moves+=debt*d;
            }

            if(need>0 && balance[right]>0){
                long debt=Math.min(balance[right], need);
                balance[right]-=debt;
                need-=debt;
                moves+=debt*d;
            }
        }
        return need==0? moves:-1;
    }
}