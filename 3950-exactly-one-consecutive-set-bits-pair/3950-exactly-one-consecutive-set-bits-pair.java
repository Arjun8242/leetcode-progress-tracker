class Solution {
    public boolean consecutiveSetBits(int n) {
        StringBuilder st=new StringBuilder();

        while(n>0){
            st.append(n&1);
            n>>=1;
        }

        st.reverse();

        int flag=0;

        for(int x=0;x<st.length()-1;x++){
            if(st.charAt(x)=='1' && st.charAt(x+1)=='1'){
                flag++;
            }
        }

        return flag==1;
    }
}