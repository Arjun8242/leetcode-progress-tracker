class Solution {
    public String generateTag(String caption) {
        String ans="#";
        String s=caption;
        s=s.toLowerCase().trim();
        int n=s.length();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch==' '){
            while(ch==' '){
                i=i+1;
                ch=s.charAt(i);
            }
                ch=Character.toUpperCase(ch);
                ans=ans+ch;
            }
            else{
                ans=ans+ch;
            }       
        }
        if(ans.length()>100){
            ans=ans.substring(0,100);
        }

        return ans;
    }
}