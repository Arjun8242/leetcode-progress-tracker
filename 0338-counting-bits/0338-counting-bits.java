class Solution {
    public int[] countBits(int n) {
        int[] bits=new int[n+1];

        for(int i=0;i<=n;i++){
            bits[i]=countSetBits(i);
        }

        return bits;
    }
    int countSetBits(int x){
        int count=0;
        while(x>1){
            count+=x&1;
            x=x>>1 ;
        }
        if(x==1) count+=1;
        return count;
    }
}