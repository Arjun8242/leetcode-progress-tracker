class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] ans=new int[2];
        for(int i=1;i<n;i++){
            if(zero(n-i) && zero(i)){
                ans[0]=n-i;
                ans[1]=i;
                return ans;
            }
        }
        return ans;
    }
    public boolean zero(int n){
        while(n>0){
            if(n%10==0) return false;
            n/=10;
        }
        return true;
    }
}