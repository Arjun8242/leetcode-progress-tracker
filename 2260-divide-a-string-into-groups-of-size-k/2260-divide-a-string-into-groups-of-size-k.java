class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n=s.length();
        int rem=n%k;

        if(rem!=0){
            int filling=k-rem;
            for(int i=0;i<filling;i++){
                s+=fill;
            }
        }
            int groups=s.length()/k;
            String[] ans=new String[groups];
            for(int i=0;i<groups;i++){
                ans[i]=s.substring(i*k,(i+1)*k);
            }
            return ans;
    }
}