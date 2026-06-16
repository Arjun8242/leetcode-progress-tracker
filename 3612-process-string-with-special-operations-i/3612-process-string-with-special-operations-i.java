class Solution {
    public String processStr(String s) {
        String res="";
        int n=s.length();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);

            if(ch=='*'){
                if(res.length()>0){
                    res=res.substring(0, res.length()-1);
                }
            }
            else if(ch=='#'){
                res=res+res;
            }
            else if(ch=='%'){
                res=reverse(res);
            }
            else{
                res=res+ch;
            }
        }
        return res;
    }
    public String reverse(String s){
        String rev="";

        for(int i=s.length()-1;i>=0;i--){
            rev+=s.charAt(i);
        }

        return rev;
    }
}