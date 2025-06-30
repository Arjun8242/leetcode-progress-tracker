class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        if(strs.length==1) return strs[0];
        String str0=strs[0];
        String str9=strs[strs.length-1];
        String ans="";
        for(int i=0;i<Math.min(str0.length(),str9.length());i++){
            if(str0.charAt(i)!=str9.charAt(i)){
                return ans;
            }
       
        else{
            ans+=str9.charAt(i);
        }
    }    
        return ans;
    }
}