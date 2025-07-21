class Solution {
    public String makeFancyString(String s) {
       StringBuilder ans=new StringBuilder(); 
        ans.append(s.charAt(0));
        int len=s.length();
        int count=1;
        if(len<3) return s;
        char ch,chh;
        for(int i=1;i<len;i++){
            ch=s.charAt(i-1);
            chh=s.charAt(i);
            if(ch==chh){
                count++;
            }
            else{
                count=1;
            }
            if(count<3) ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}