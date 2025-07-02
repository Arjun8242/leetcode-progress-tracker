class Solution {
    public int possibleStringCount(String word) {
        int len=word.length();
        int count=1;
        for(int i=0;i<len-1;i++){
            if(word.charAt(i)==word.charAt(i+1)){
                count++;
            }
        }
            return count;
    }
}