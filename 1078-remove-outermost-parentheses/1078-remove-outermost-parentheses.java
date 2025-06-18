class Solution {
    public String removeOuterParentheses(String s) {
        String ans="";
        int len=s.length();
        int count=0;
        for(int i=0;i<len;i++){
            char ch=s.charAt(i);
            if(ch=='(')
            {
                if(count!=0){
                ans+=ch;
                }
                count++;
            }
            else{
                if(count!=1){
                    ans+=ch;
                }
                count--;
        }
    }
        return ans;
    }
}