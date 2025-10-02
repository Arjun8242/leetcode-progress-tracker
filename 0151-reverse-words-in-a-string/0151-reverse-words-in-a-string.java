class Solution {
    public String reverseWords(String s) {
        String[] split=s.trim().split("\\s+");
        String dummy="";

        for(int i=split.length-1;i>=0;i--){
            dummy+=" "+split[i];
        }
        return dummy.trim();
    }
}