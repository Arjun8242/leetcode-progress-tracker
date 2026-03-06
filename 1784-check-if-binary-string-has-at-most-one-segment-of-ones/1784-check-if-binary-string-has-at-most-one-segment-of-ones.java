class Solution {
    public boolean checkOnesSegment(String s) {
        boolean seenzero=false;

        for(char ch:s.toCharArray()){
            if(ch=='0') seenzero=true;
            if(ch=='1' && seenzero) return false;
        }
        return true;
    }
}