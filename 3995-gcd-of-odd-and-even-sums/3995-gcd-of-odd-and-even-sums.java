class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumodd=n*n;
        int sumeven=n*(n+1);       
       int gcd=gcd(sumodd,sumeven);
       return gcd;
    }
    public int gcd(int sumodd, int sumeven){
        int g=0;
        for(int i=1;i<=Math.min(sumeven,sumodd);i++){
            if(sumodd%i==0 && sumeven%i==0){
                g=i;
            }
        }
        return g;
    }
}