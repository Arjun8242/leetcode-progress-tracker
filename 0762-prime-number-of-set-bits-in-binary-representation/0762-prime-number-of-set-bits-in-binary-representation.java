class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count=0;
        while(left<=right){
            int bits=Integer.bitCount(left++);
            if(prime(bits)){
                count++;
            }
        }
        return count;
    }
    public boolean prime(int n){
        if(n<=1) return false;

        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}