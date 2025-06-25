class Solution {
    public long kMirror(int k,int n){
        long s=0;
        for(long l=1;n>0;l*=10){
            for(long i=l;n>0&&i<l*10;i++){
                long p=gp(i,true);
                if(kp(p,k)){
                    s+=p;
                    n--;
                }
            }
            for(long i=l;n>0&&i<l*10;i++){
                long p=gp(i,false);
                if(kp(p,k)){
                    s+=p;
                    n--;
                }
            }
        }
        return s;
    }

    long gp(long n,boolean o){
        long x=n;
        if(o)x/=10;
        while(x>0){
            n=n*10+x%10;
            x/=10;
        }
        return n;
    }

    boolean kp(long n,int k){
        long r=0,t=n;
        while(t>0){
            r=r*k+t%k;
            t/=k;
        }
        return n==r;
    }
}
