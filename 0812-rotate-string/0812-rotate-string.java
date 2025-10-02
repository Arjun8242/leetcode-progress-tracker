class Solution {
    public boolean rotateString(String s, String goal) {
        // String dummy="";
        // if(goal.length()!=s.length()) return false;
        // for(int i=0;i<s.length();i++){
        //     dummy=s.substring(i, s.length())+s.substring(0, i);
        //     if(dummy.equals(goal)) {
        //         return true;
        //     }
        // }
        // return false;
        return s.length()==goal.length() && (s+s).contains(goal);
    }   
}