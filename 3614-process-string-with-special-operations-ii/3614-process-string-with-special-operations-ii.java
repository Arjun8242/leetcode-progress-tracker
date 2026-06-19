class Solution {
    public char processStr(String s, long k) {
        int n=s.length();
        long[] len=new long[n];
        long curr=0;

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            
            if(Character.isLowerCase(ch)){
                curr++;
            }
            else if(ch=='*'){
                if(curr>0) curr--;
            }
            else if(ch=='#'){
                curr*=2;
            }
            else{
                //do notthing
            }
            len[i]=curr;
        }

        if(k>=curr) return '.';

        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);

            long prevlen=(i==0)?0:len[i-1];

            if(Character.isLowerCase(ch)){
                if(k==prevlen){
                    return ch;
                }
            }
            else if(ch=='#'){
                k%=prevlen;
            }
            else if(ch=='%'){
                k=prevlen-1-k;
            }
            else{
                continue;
            }
        }
        return '.';


    }
}