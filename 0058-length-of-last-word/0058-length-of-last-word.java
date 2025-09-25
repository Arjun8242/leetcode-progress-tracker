class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        String last="";
        int n=s.length();
        for(int i=n-1;i>=0;i--){
              if (s.charAt(i) != ' ') {
                last=s.charAt(i)+last;
            } else {
                break;
        }
    }
    return last.length();
}
}